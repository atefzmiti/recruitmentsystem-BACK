package com.scoremanagment.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scoremanagment.entities.Condidat;
import com.scoremanagment.entities.DAOUser;
import com.scoremanagment.entities.Ressource;
import com.scoremanagment.repository.CondidatRepository;
import com.scoremanagment.repository.RessourceRepository;
import com.scoremanagment.repository.UserDao;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private CondidatRepository userDao;

	
	@Autowired
	private RessourceRepository ressourcerep;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Condidat user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public Condidat save(Condidat user) {
		Condidat newUser = new  Condidat();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setUsername(user.getUsername());
		newUser.setRoles(user.getRoles());
		newUser.setAddress(user.getAddress());
		newUser.setExperienceparmois(user.getExperienceparmois());

		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}
	
	public Ressource saveressource(Ressource user) {
		Ressource newUser = new  Ressource();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setUsername(user.getUsername());
		newUser.setRoles(user.getRoles());
		newUser.setAddress(user.getAddress());
		newUser.setDisponibilite(user.getDisponibilite());

		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return ressourcerep.save(newUser);
	}
	

}