package com.balodza.spring.beans.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SomeController {
    
    @Autowired
    private SomeService service;
        
    @GetMapping("/getUuid")
    public String getUuid() {
        log.info("call to /getUuid");
        return service.getUuid();
    }
}
