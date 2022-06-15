//package com.learn.app.security;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class LearnControllerAuthEntryPoint extends BasicAuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
//        super.commence(request, response, authException);
//    }
//
//    @Override
//    public void afterPropertiesSet(){
//        setRealmName("User");
//        super.afterPropertiesSet();
//    }
//}
