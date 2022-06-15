package com.learn.app.jpa.entity.listener;

import com.learn.app.data.Address;
import com.learn.app.jpa.entity.AddressRepository;
import com.learn.app.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepoImpl implements AddressRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from ADDRESS", Integer.class);
    }

    @Override
    public int save(Address address, User user) {
        return jdbcTemplate.update(
                "insert into ADDRESS (ID,STREET_NAME) values(?,?)",
                user.getId(), address.getStreet());
    }

    @Override
    public int update(Address address) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }
}
