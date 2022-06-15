//package com.learn.app.service;
//
//import com.learn.app.jpa.entity.User;
//import com.learn.app.jpa.entity.UserRepositary;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//@RunWith(MockitoJUnitRunner.class)
//public class UserDetailsSvcTest {
//
//    @InjectMocks
//    private UserDetailsSvcImpl userService;
//
//    @Mock
//    UserRepositary userRepositary;
//
//    @Before
//    public void  init_mocks() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void loadByUserName() {
//
//        User user = new User();
//        user.setLoginName("dummy");
//        user.setPassword("password");
//        Mockito.when(userRepositary.findByLogin("dummy")).thenReturn(user);
//        UserDetails details = userService.loadUserByUsername("dummy");
//        Assert.assertEquals(user.getLoginName(), details.getUsername());
//    }
//
//    @Test(expected = UsernameNotFoundException.class)
//    public void loadByUserName_No_user_found() {
//
//        Mockito.when(userRepositary.findByLogin("dummy")).thenReturn(null);
//        UserDetails details = userService.loadUserByUsername("dummy");
//
//    }
//
//}
