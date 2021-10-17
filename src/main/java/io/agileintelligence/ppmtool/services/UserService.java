<<<<<<< HEAD
package io.agileintelligence.ppmtool.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtool.domain.User;
import io.agileintelligence.ppmtool.exceptions.UsernameAlreadyExistException;
import io.agileintelligence.ppmtool.repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User saveUser(@Valid User newUser) {
		
try {
	newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
	
	newUser.setUsername(newUser.getUsername());
	newUser.setConfirmPassword("");
	
	return userRepository.save(newUser);
	
}catch(Exception e) {
	throw new UsernameAlreadyExistException("Username "+newUser.getUsername()+" already exist");
	
}
		
		
	}

	
}
||||||| empty tree
=======
package io.agileintelligence.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtool.domain.User;
import io.agileintelligence.ppmtool.exceptions.UsernameAlreadyExistException;
import io.agileintelligence.ppmtool.repositories.UserRepository;

@Service
public class UserService  {
	
	@Autowired
	private UserRepository userRepository;


  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  
  public User saveUser(User newUser) {
	  try {
			newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
			
			newUser.setUsername(newUser.getUsername());
			newUser.setConfirmPassword("");
			
			return userRepository.save(newUser);
			
		}catch(Exception e) {
			throw new UsernameAlreadyExistException("Username "+newUser.getUsername()+" already exist");
			
		}
  }

}
>>>>>>> origin/master
