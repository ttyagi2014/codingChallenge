package com.tanuj.accounts.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tanuj.accounts.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	
	
	@Query(nativeQuery = true,value = "select id from userdetails where username=:username")
	Integer findUserIdByName(String username);
	

}
