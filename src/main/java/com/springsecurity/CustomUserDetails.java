package com.springsecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springsecurity.model.Role;
import com.springsecurity.model.User;

public class CustomUserDetails implements UserDetails {
		
	private String username;
	private String password;
	Collection<? extends GrantedAuthority> authorities;
	
	public CustomUserDetails(User byUsername) {
		this.username = byUsername.getUsername();
		this.password = byUsername.getPassword();
		
		List<GrantedAuthority> auths = new ArrayList<>();
		for(Role role: byUsername.getRoles()) {
			auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
		}
		
		this.authorities = auths;	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}