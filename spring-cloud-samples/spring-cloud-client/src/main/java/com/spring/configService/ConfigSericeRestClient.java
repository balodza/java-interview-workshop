package com.spring.configService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigSericeRestClient {
    
    @Value("${app.name}")
    private String appName;

    @Value("${app.description}")
    private String appDescription;

    public static void main(String[] args) {
        SpringApplication.run(ConfigSericeRestClient.class, args);
    }

    /**
     * call http://localhost:8887/app/info
     */
    @GetMapping(value = "/app/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public AppInfo appInfo() {
        final AppInfo appInfo = new AppInfo();
        appInfo.setName(appName);
        appInfo.setDescription(appDescription);
        return appInfo;
    }
}