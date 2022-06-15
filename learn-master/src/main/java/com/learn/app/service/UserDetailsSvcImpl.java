package com.learn.app.service;

import com.learn.app.jpa.entity.User;
import com.learn.app.jpa.entity.UserRepositary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsSvcImpl implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserRepositary userRepositary;

    /**
     * 1. given user name , return user and password
     * 2. user found do not return password
     * 3. user found and do not return userName
     * 3. no use found
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // add log
        // instrument for monitoring

        // send emails
        // send tracking
        try {
            return getUserDetailsInternal(username);
        } catch (Exception e){
            logger.error("loadUserByUsername:returned user not found",e);
            throw e;
        }

    }

    private UserDetails getUserDetailsInternal(String username) {
        User user = userRepositary.findByLogin(username);
        if(user==null) {
            throw new UsernameNotFoundException("User not found"+ username);
        }
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getLoginName()).password(user.getPassword()).authorities("USER").build();
        return userDetails;
    }
}
