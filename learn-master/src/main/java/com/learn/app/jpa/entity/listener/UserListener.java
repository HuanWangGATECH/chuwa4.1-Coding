package com.learn.app.jpa.entity.listener;

import com.learn.app.jpa.entity.User;

import javax.persistence.PostPersist;
import javax.persistence.PreRemove;

public class UserListener {
    @PostPersist
    public void logAddition(Object user) {
        System.out.println("UserListener::Added new user:" + ((User) user).getFirstName ());
        // send email
        // send SMS
        // call API
    }

    @PreRemove
    public void logRemove(Object user) {
        System.out.println("UserListener::removed new user:" + ((User) user).getFirstName ());
        // send email
        // send SMS
        // call API
    }
}
