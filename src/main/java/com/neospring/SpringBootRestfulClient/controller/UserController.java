package com.neospring.SpringBootRestfulClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neospring.SpringBootRestfulClient.model.User;
import com.neospring.SpringBootRestfulClient.service.UserService;

import dto.UserPojo;
import dto.UserPojoSurname;


@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
//@PostMapping("users")
//	public ResponseEntity<User> createUser(@RequestBody User user){
//		User savedUser = userService.createUser (user);
//		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
//	}
//	
	@PostMapping("/users")
public User saveUser(@Validated @RequestBody User user ) {
		return userService.saveUser(user);
	}
	@GetMapping("/users")
	public List<User> fetchUserList(){
		
		return userService.fetchUserList();
	}	
	@PutMapping("/users/{id}")
	public  User updateUser(@RequestBody User  user , @PathVariable("id") Integer id) {
		return userService.updateUser(user, id);
		
	}
@RequestMapping(value="/users/{name}", method =RequestMethod.GET)
	public   UserPojo getUser(@PathVariable("name") String name){
		return userService.findByName(name);
	}
	@RequestMapping(value="/users/usersurname/{surname}", method =RequestMethod.GET)

	public UserPojoSurname  getSurname(@PathVariable("surname") String surname) {
	return userService.findBySurname(surname);
	}

	@GetMapping("/users/useremail/{email}")
	public List<User> getSortEmail(@PathVariable("email") String field){
		return userService.sortByEmail(field);
	}
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") Integer id) {
		
	userService.deleteUserById(id);
	
	}

}
