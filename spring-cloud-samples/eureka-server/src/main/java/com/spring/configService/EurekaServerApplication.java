package com.spring.configService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    /**
     * http://localhost:8886/ui
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}