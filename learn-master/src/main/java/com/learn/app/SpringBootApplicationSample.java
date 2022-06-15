package com.learn.app;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = { "com.learn.app" })
@EnableEncryptableProperties
public class SpringBootApplicationSample extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<SpringBootApplicationSample> applicationClass = SpringBootApplicationSample.class;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationSample.class, args);
    }
}
