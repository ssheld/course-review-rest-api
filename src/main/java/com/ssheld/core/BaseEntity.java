package com.ssheld.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Author: Stephen Sheldon 4/14/2019
 */

@MappedSuperclass
public abstract class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private final Long id;

  public BaseEntity() {
    this.id = null;
  }
}
