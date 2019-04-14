package com.ssheld.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Author: Stephen Sheldon 4/14/2019
 */

@MappedSuperclass
public abstract class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Version
  private Long version;

  public BaseEntity() {
    this.id = null;
  }
}
