package com.learn.app.jpa.entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepositary extends CrudRepository<User, Long> {

    // custom query example and return a stream
    @Query("select u from User u where u.email = :email")
    List<User> findByEmail(@Param("email") String email);

    @Query("select u from User u where u.loginName = :loginName")
    User findByLogin(@Param("loginName") String loginName);

    @Query("select u from User u where u.id = :id")
    User findById(@Param("id") String id);

    List<User> findAll();
}
