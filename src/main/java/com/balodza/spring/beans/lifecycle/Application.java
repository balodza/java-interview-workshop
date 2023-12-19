package com.balodza.spring.beans.lifecycle;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        Map<String, Object> props = new HashMap<>();
        props.put("server.port", "8001");
        app.setDefaultProperties(props);
        app.run(args);
    }

}