package com.scoremanagment.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scoremanagment.config.JwtTokenUtil;
import com.scoremanagment.entities.DAOUser;
import com.scoremanagment.repository.CondidatRepository;
import com.scoremanagment.repository.UserDao;
import com.scoremanagment.service.UserService;

@RestController
public class AppController {

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService ;
	
	
	
	@GetMapping("/user")
	public DAOUser getUserFromToken(HttpServletRequest request) {
		
		//get token from header
		final String requestTokenHeader = request.getHeader("Authorization");
		
		// eliminate "Bearer" from token string
		String jwtToken = requestTokenHeader.substring(7);
		
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
		
		DAOUser user = userDao.findByUsername(username);
		
		return user;
		
	}
	
	
	
	@GetMapping("/users/{userId}")
	public DAOUser getUserById(@PathVariable("userId") long userId) {

		return userDao.findUserById(userId);
	}
	@GetMapping("/allusers")
	public List<DAOUser> getUsers() {

		return userDao.findAllUsers();
	}
	
	
	
} 
