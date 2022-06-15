package com.learn.app.jpa.entity;

import com.learn.app.data.Address;

import java.util.List;

public interface AddressRepository {

    int count();

    int save(Address address, User user);

    int update(Address address);

    int deleteById(Long id);

    List<Address> findAll();

}
