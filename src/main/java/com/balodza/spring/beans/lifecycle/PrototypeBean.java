package com.balodza.spring.beans.lifecycle;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {
    @PostConstruct
    public void init() {
        log.info("Post Construct method completed");
    }
    
    public String getMessage() {
        log.info("getMessage method completed");
        return "Some message";
    }
}
