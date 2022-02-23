package com.api.api.Repository;

import com.api.api.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends CrudRepository<User,Integer> {
    
}
