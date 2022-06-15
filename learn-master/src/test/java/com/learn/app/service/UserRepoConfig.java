package com.learn.app.service;

import com.learn.app.jpa.entity.UserRepositary;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class UserRepoConfig {


        @Bean
        @Primary
        public UserRepositary userRepositary() {
            return Mockito.mock(UserRepositary.class);
        }
}
