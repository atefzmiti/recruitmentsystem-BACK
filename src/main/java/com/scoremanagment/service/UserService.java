package com.scoremanagment.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scoremanagment.config.JwtTokenUtil;
import com.scoremanagment.entities.DAOUser;

import com.scoremanagment.repository.UserDao;

@Component

public class UserService {

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	UserDao userDao;
	
	
	
	// This function return User object from token
	public DAOUser getCurrentUser(HttpServletRequest request) {
		
		
		//get token from header
		final String requestTokenHeader = request.getHeader("Authorization");
		
		// eliminate "Bearer" from token string
		String jwtToken = requestTokenHeader.substring(7);
		
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
		
		DAOUser user = userDao.findByUsername(username);
		
		return user;
	}
	
	
	
	
	
}
