package com.learn.app.jpa.entity;

import com.learn.app.jpa.entity.listener.UserListener;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners({ UserListener.class})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "USER_ID_SEQ")
    @SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "USER_ID_SEQ", initialValue = 4)
    Long id;

    @Column(name = "LOGIN_NAME")
    String loginName;

    @Column(name = "PASSWORD")
    String password;

    @Column(name = "FIRST_NAME")
    String firstName;

    @Column(name = "LAST_NAME")
    String lastName;

    @Column(name = "EMAIL")
    String email;

    @Column(name = "CREATED_DATE")
    @CreationTimestamp
    Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
