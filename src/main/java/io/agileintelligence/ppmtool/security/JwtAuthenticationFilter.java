package io.agileintelligence.ppmtool.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.agileintelligence.ppmtool.domain.User;
import io.agileintelligence.ppmtool.services.CustomUserDetailService;

import java.util.*;

import static io.agileintelligence.ppmtool.security.SecurityConstants.*;
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private CustomUserDetailService customUserDetailsService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			
			String jwt = getJWTFromRequest(request);
		
			if(StringUtils.hasText(jwt)&& tokenProvider.validateToken(jwt)) {
				Long userId= tokenProvider.getUserIdfromJWT(jwt);
				
				User userDetails = customUserDetailsService.loadUserById(userId);
	UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,Collections.emptyList());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			}
		}catch(Exception ex) {
			logger.error("Could not set user authentication in security context");
		}
		
		filterChain.doFilter(request, response);
		
	}

	
	private String getJWTFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader(HEADER_STRING);
		
		if(StringUtils.hasText(bearerToken)&& bearerToken.startsWith(TOKEN_PREFIX)) {
			return bearerToken.substring(7, bearerToken.length());
			
		}
		return null;
	}
	
}
