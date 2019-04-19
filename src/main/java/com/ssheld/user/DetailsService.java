package com.ssheld.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Author: Stephen Sheldon 4/19/2019
 */

@Component
public class DetailsService implements UserDetailsService {
  @Autowired
  UserRepository users;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = users.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException(username + " was not found");
    }
    // Expected to return something that implements the UserDetails interface
    return new org.springframework.security.core.userdetails.User(
        user.getUsername(),
        user.getPassword(),
        // Get user roles to pass to authority list
        AuthorityUtils.createAuthorityList(user.getRoles())
    );
  }
}
