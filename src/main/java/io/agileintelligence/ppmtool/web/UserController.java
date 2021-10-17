<<<<<<< HEAD
package io.agileintelligence.ppmtool.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import static io.agileintelligence.ppmtool.security.SecurityConstants.*;
import io.agileintelligence.ppmtool.domain.User;
import io.agileintelligence.ppmtool.payload.JWTSuccessResponse;
import io.agileintelligence.ppmtool.payload.LoginRequest;
import io.agileintelligence.ppmtool.security.JwtTokenProvider;
import io.agileintelligence.ppmtool.services.MapValidationErrorService;
import io.agileintelligence.ppmtool.services.UserService;
import io.agileintelligence.ppmtool.validation.UserValidator;

@RestController
@RequestMapping("/api/users")
public class UserController {

	
	
	
@Autowired
private	MapValidationErrorService mapValidationErrorService;
	
@Autowired
private JwtTokenProvider tokenProvider;

@Autowired
private UserValidator userValidator;

@Autowired
private UserService userService;

@Autowired
private AuthenticationManager authenticationManager;
	

@PostMapping("/login")
public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
	ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
	
	if(errorMap!=null) return errorMap;
	
	
	Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
					loginRequest.getUsername(),
					loginRequest.getPassword()));
	
	SecurityContextHolder.getContext().setAuthentication(authentication);
	
	String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);

 return ResponseEntity.ok(new JWTSuccessResponse(true, jwt));
}




    @PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result){
		
		userValidator.validate(user, result);
    	
    	ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result); 
	
		if(errorMap!=null)return errorMap;
		
		User newUser = userService.saveUser(user);
	
	return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	
}
||||||| empty tree
=======
package io.agileintelligence.ppmtool.web;

import static io.agileintelligence.ppmtool.security.SecurityConstants.TOKEN_PREFIX;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.agileintelligence.ppmtool.domain.User;
import io.agileintelligence.ppmtool.payload.JWTSuccessResponse;
import io.agileintelligence.ppmtool.payload.LoginRequest;
import io.agileintelligence.ppmtool.security.JwtTokenProvider;
import io.agileintelligence.ppmtool.services.MapValidationErrorService;
import io.agileintelligence.ppmtool.services.UserService;
import io.agileintelligence.ppmtool.validation.UserValidator;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	 
	    @Autowired
	    private JwtTokenProvider tokenProvider;

	    @Autowired
	    private AuthenticationManager authenticationManager;
	
	 @PostMapping("/login")
	    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
	        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
	        if(errorMap != null) return errorMap;

	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginRequest.getUsername(),
	                        loginRequest.getPassword()
	                )
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        String jwt = TOKEN_PREFIX +  tokenProvider.generateToken(authentication);

	        return ResponseEntity.ok(new JWTSuccessResponse(true, jwt));
	    }

	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result){
		userValidator.validate(user,result);
		ResponseEntity<?> errorMap= mapValidationErrorService.MapValidationService(result);
		
		if(errorMap!=null)return errorMap;
		
		User newUser = userService.saveUser(user);
		
		
		
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
		
	}
}
>>>>>>> origin/master
