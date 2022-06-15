//package com.learn.app.service;
//
//import com.learn.app.jpa.entity.User;
//import com.learn.app.jpa.entity.UserRepositary;
//import org.junit.Assert;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@SpringBootTest
//@ActiveProfiles("test")
//@RunWith(SpringJUnit4ClassRunner.class)
//public class UserDetailsSvcImplTest {
//
//    @Autowired
//    private UserDetailsService userService;
//
//    @Autowired
//    UserRepositary userRepositary;
//
//    @Test
//    @Ignore
//    public void loadByUserName() {
//
//        User user = new User();
//        user.setLoginName("dummy");
//        user.setPassword("password");
//        Mockito.when(userRepositary.findByLogin("dummy")).thenReturn(user);
//        UserDetails details = userService.loadUserByUsername("dummy");
//        Assert.assertEquals(user.getLoginName(), details.getUsername());
//    }
//}
