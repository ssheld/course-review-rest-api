package com.ssheld.core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;

/**
 * Author: Stephen Sheldon 4/14/2019
 */

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

  @Autowired
  private Validator validator;

  @Override
  public void configureValidatingRepositoryEventListener(
      ValidatingRepositoryEventListener validatingListener) {
      validatingListener.addValidator("beforeCreate", validator);
      validatingListener.addValidator("beforeSave", validator);

  }
}
