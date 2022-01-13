package com.neospring.SpringBootRestfulClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neospring.SpringBootRestfulClient.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {


 @Query(value = "SELECT * FROM user_new  u WHERE u.name = :name", 
			  nativeQuery = true)
	 User findByName(@Param("name") String name);
 
 @Query(value = "SELECT * FROM user_new u WHERE u.surname= :surname ",
		 nativeQuery = true)
	User findBySurname(@Param("surname") String surname);
 
 
}
