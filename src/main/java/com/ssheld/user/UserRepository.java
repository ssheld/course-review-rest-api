package com.ssheld.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// We want exported = false because we don't want to
// expose our entire repository to users. They don't need
// to know all the users in our repo!!
@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
