package com.spring.configService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigSericeRestClient {
    
    @Value("${user.role}")
    private String role;

    @Value("${user.password}")
    private String password;

    public static void main(String[] args) {
        SpringApplication.run(ConfigSericeRestClient.class, args);
    }

    /**
     * call http://localhost:8887/user/myNameIsBob
     */
    @GetMapping(value = "/user/{username}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String whoami(@PathVariable("username") String username) {
        return String.format("Hello %s! You are a(n) %s and your password is '%s'.\n", username, role, password);
    }
}