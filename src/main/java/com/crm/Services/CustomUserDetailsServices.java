package com.crm.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crm.DAO.UsersDAO;
import com.crm.Models.Users;
import com.crm.Utils.UserPrincipal;

@Service
public class CustomUserDetailsServices implements UserDetailsService {
	
	@Autowired
	UsersDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = null;
		
		user = userDAO.findByEmail(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		return new UserPrincipal(user);
	}

}
