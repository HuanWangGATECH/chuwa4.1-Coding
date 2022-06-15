package com.learn.app.controller.advice;

import com.learn.app.security.JWTHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SignInController {

    @Autowired
    JWTHandler jwtHandler;

    @GetMapping("/login")
    public String login() {
       return "login";
    }

    @GetMapping(path="/token/{userName}",produces = "application/json")
    public ResponseEntity<Map<String, String>> token(@PathVariable String userName) {
        Map<String, String>  map = new HashMap<>();
        map.put("token",jwtHandler.generateJwtToken(userName));
        return ResponseEntity.ok()
                .body(map);

    }

}
