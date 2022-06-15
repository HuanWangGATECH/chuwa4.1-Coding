package com.learn.app;

import com.learn.app.data.Address;
import com.learn.app.data.ErrorInfo;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@ComponentScan("com.learn.app.data")
public class Config {


    @Bean
    public Address address() {
        return new Address("myStreet");
    }

    @Bean
    public ErrorInfo notFoundError() {
        ErrorInfo errorInfo =new ErrorInfo();
        errorInfo.setMessage("error from bean config ");
        errorInfo.setId("not_found_error");
        return errorInfo;
    }

    @Bean
    public ErrorInfo userNotFound() {
        ErrorInfo errorInfo =new ErrorInfo();
        errorInfo.setMessage("error from bean config ");
        errorInfo.setId("user_not_found");
        return errorInfo;
    }

    @Bean
    public ErrorInfo invalidCredentials() {
        ErrorInfo errorInfo =new ErrorInfo();
        errorInfo.setMessage("invalid credentials, userid/password not valid");
        errorInfo.setId("invalid_credentials");
        return errorInfo;
    }


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        return builder
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
