package com.flightapp.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flightapp.user.db.AppUserRepository;
import com.flightapp.user.entity.AppUser;

@Service
public class AppUserServiceImpl implements UserDetailsService {

	@Autowired
	AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		AppUser user = appUserRepository.findByUserName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("User does not exist: " + userName));
		return AppUserDetailsImpl.build(user);
	}

}
