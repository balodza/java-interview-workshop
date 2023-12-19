package com.balodza.spring.beans.lifecycle;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepA {
    //Circular dependency issue fixed with @Lazy
    @Autowired
    @Lazy
    private DepB dep;

    @PostConstruct
    public void init() {
        log.info("Post Construct method completed");
    }
}
