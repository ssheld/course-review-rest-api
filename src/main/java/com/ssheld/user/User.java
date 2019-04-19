package com.ssheld.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssheld.core.BaseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

/**
 * Author: Stephen Sheldon 4/15/2019
 */

@Entity
public class User extends BaseEntity {
  public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
  private String firstName;
  private String lastName;
  private String username;
  // Use JsonIgnore, we don't ever want anyone to
  // see a user password.
  @JsonIgnore
  private String password;
  // User authorization using role based system
  @JsonIgnore
  private String[] roles;

  protected User() {
    // Call constructor for BaseEntity
    super();
  }

  public User(String username, String firstName, String lastName, String password,
              String[] roles) {
    // Call User default constructor
    this();
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    setPassword(password);
    this.roles = roles;
  }

  // Set user password and use BCrypt to encode it
  public void setPassword(String password) {
    this.password = PASSWORD_ENCODER.encode(password);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public String[] getRoles() {
    return roles;
  }

  public void setRoles(String[] roles) {
    this.roles = roles;
  }
}
