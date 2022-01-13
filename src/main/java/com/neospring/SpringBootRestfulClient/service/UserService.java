package com.neospring.SpringBootRestfulClient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.neospring.SpringBootRestfulClient.model.User;
import com.neospring.SpringBootRestfulClient.repository.UserRepository;

import dto.UserPojo;
import dto.UserPojoSurname;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	

	public User saveUser(User user) {
		return userRepository.save(user);
	}


  public List<User> fetchUserList() {
	  
	  return userRepository.findAll();
  }
		
  public User updateUser(User user , Integer id) {
	  
	 User userDb=userRepository.findById(id).get();
	 
	 if(Objects.nonNull(user.getName())  &&  !"".equalsIgnoreCase(user.getName())){
		 userDb.setName(user.getName());
		 
	 }
	 if(Objects.nonNull(user.getSurname()) && !"".equalsIgnoreCase(user.getSurname())) {
		 userDb.setSurname(user.getSurname());
	 }
	 if(Objects.nonNull(user.getEmail()) &&  ! "".equalsIgnoreCase(user.getEmail())){
		 userDb.setEmail(user.getEmail());
	 }
	 
	 if(Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())) {
		 userDb.setPassword(user.getSurname());
	 }
	 
	  return userRepository.save(userDb);
  }
//  
//  public List<User> findAllMatches(String name) {
//	  
//	  List<User> users =new ArrayList<>();
//	  
//	  for(User ur : users) {
//		  
//		 if()
//	  }
//	  return null;
//  }
  
  
  
  public void deleteUserById( Integer id) {
	  
	  userRepository.deleteById(id);
  }


public UserPojo findByName(String name) {
	 User userEntity = null;
	 UserPojo userPojo =new UserPojo();
	 userEntity = userRepository.findByName(name);
	 
	 if(userEntity!= null) {
      userPojo.setName(userEntity.getName()!= null ? userEntity.getName():" ");
      userPojo.setEmail(userEntity.getEmail() != null ? userEntity.getEmail(): " ");
      userPojo.setSurname(userEntity.getSurname()!= null ? userEntity.getSurname(): " ");
      userPojo.setPassword(userEntity.getPassword()!=null ? userEntity.getSurname(): " ");
      
	 }
	 return userPojo;
}


public UserPojoSurname findBySurname(String surname) {
	
	

	User userEnititySurname = null;
	UserPojoSurname userPojoSurname= new  UserPojoSurname();
	userEnititySurname=userRepository.findBySurname(surname);
	
	
	if(userEnititySurname!=null) {
		
		userPojoSurname.setName(userEnititySurname.getName() != null ?userEnititySurname.getName():" ");
		userPojoSurname.setEmail(userEnititySurname.getEmail() != null ? userEnititySurname.getEmail():" ");
		userPojoSurname.setSurname(userEnititySurname.getSurname() != null ? userEnititySurname.getSurname():" " );
		userPojoSurname.setPassword(userEnititySurname.getPassword() != null ? userEnititySurname.getPassword():" ");
	}
	
	return userPojoSurname;
}
public List<User> sortByEmail(String field){
	
	return userRepository.findAll(Sort.by("email").ascending().and(Sort.by("password")));
	
}
}
