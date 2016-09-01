package com.jorge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.model.User;
import com.jorge.service.UserService;

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


/**
 * To use a specific HTTP method, add the method argument in the @RequestMapping annotation:
 *		@RequestMapping(value = "/{id}", method = RequestMethod.POST)
 *
 * To secure a REST service:
 * 		Use HTTPS so that data transfers between the client and server are encrypted. Refer to the
 * 		Using HTTPS with Tomcat, Managing Security.
 * 	
 * 		If you want only authorized clients to query it, you can use HTTP Basic Authentication. Refer to
 * 		the Authenticating users using the default login page, Managing Security, especially, the httpBasic() method. 
 * 
 * 		Another possibility is to use an OAuth workflow. It's more complicated, but it avoids the client having to send 
 * 		a username and password at each request. That's the method chosen by Facebook and Twitter for their REST API, for example.
 *  
 */


/**
 * UserControlleris a standard Spring controller except for the @RestController annotation, which
 * will automatically convert the objects returned by the controller methods to JSON, using the Jackson
 * library
 *
 */

@RestController // Necessary for REST service, automatically convert the objects returned by the controller methods to JSON, 
                // using the Jackson library. We needn't @Controller annotation
@RequestMapping("users*") // Make url like http://localhost:8080/spring13_RESTserver/users (userList() method) or http://localhost:8080/spring13_RESTserver/users/2 (findUser(@PathVariable("id") Long userId) method)
public class UserController {
	
	/**************************************************************
	 * SERVER SIDE
	 
	 * The Spring web application is now a REST service. It will return User objects serialized to
	 * JSON in response to the /users and /users/1 URL requests
	 * 
	 */
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	// Controller method returning the list of all users to the client service
	// SERVER SIDE
	public List<User> userList() {
		List<User> userList = userService.findAll();
		
		return userList;
	}
	
	@RequestMapping("/{id}")
	// Controller method returning the user corresponding to a given ID to the client service
	// SERVER SIDE
	public User findUser(@PathVariable("id") Long userId) {
		User user = userService.findUser(userId);
		
		return user;
	}
	
}
