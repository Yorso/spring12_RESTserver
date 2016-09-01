package com.jorge.service;

import java.util.LinkedList;
import java.util.List;

import com.jorge.model.User;

/**
 * Using the Java RMI, HTTP Invoker, Hessian, and REST
 * 
 * 		HTTP Invoker to interact with another Spring application
 * 		Java RMI to interact with another Java application not using Spring
 * 		Hessian to interact with another Java application not using Spring when you need to go over	proxies and firewalls
 * 		SOAP if you have to
 * 		REST for all other cases. REST is currently the most popular option; it's simple, flexible, and cross-platform
 *
 */

//SERVER SIDE
public class UserService {
	
	List<User> userList = new LinkedList<User>();
	
	public UserService() {
		User user1 = new User(1L, "Merlin", 777);
		userList.add(user1);
		
		User user2 = new User(2L, "Arthur", 123);
		userList.add(user2);
	}
	
	public List<User> findAll() {
		return userList;
	}
	
	public User findUser(Long id) {
		
		for (User user : userList) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		
		return null;
	}
}
