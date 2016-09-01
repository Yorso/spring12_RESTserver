/**
 * This is a configuration class
 * 
 */

package com.jorge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
@Configuration // This declares it as a Spring configuration class
@EnableWebMvc // This enables Spring's ability to receive and process web requests. Necessary for interceptors too.
@ComponentScan(basePackages = { "com.jorge.controller" }) // This scans the com.jorge.controller package for Spring components

// @Import({ DatabaseConfig.class, SecurityConfig.class }) => //If you are using a Spring application without a 'ServletInitializer' class,
														      // you can include other configuration classes from your primary configuration class

public class AppConf extends WebMvcConfigurerAdapter { // Extend from WebMvcConfigurerAdapter is necessary for interceptors

	 /***************************************************************************************************
	  * Creating a REST service
	  * 
	  * REST uses a web service architecture; here, a client sends an HTTP request to a server, which sends
	  * back an HTTP response. JSON is most of the time used for data transfer. The list of URLs supported
	  * by the server is called the REST API. These URLs are kept simple using different HTTP methods.
	  * For example, the /users/3 request using the GET method will return the user whose ID is 3. The
	  * /users/3 request using the DELETE method will delete that same user.
	  * We will create a simple REST service that will allow a REST client to query and
	  * modify a list of User objects on the server.
	  * 
	  * 
	  * The Spring web application is now a REST service. It will return User objects serialized to
	  * JSON in response to the /users and /users/1 URL requests
	  * 
	  */
	
	@Bean
	public UserService userService() {
	    return new UserService();
	}
	
	
	 
}