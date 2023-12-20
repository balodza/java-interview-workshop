package com.spring.configService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * https://www.baeldung.com/spring-cloud-configuration
 * Calls :
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 * 
 * Prerequisites :
 * mkdir ~
 * mkdir config-repo
 * cd config-repo
 * git init
 * $> echo 'user.role=Developer' > config-client-development.properties
 * $> echo 'user.role=User'      > config-client-production.properties
 * $> git add .
 * $> git commit -m 'Initial config-client properties'
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigService {

    public static void main(String[] arguments) {
        SpringApplication.run(ConfigService.class, arguments);
    }
}
