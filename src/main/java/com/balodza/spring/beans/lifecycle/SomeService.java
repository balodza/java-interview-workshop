package com.balodza.spring.beans.lifecycle;

import java.util.UUID;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service("someNamedServiceImplementation")
@Slf4j
public class SomeService implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    
    private BeanFactory beanFactory;
    
    private ApplicationContext applicationContext;
    
    private String beanName;
    
    // not used, injected as single ton here
    @Autowired
    private PrototypeBean prototypeBean;
    
    @PostConstruct
    public void init() {
        log.info("Post Construct method completed");
    }
    
    @PreDestroy
    public void preDestroy() {
        log.info("Pre Destroy method completed");
    }
    
    public String getUuid() {
        log.info("getUuid called");
        return UUID.randomUUID() + getPrototypeBean().getMessage();
    }

    // how to get prototype bean out of singleton bean 
    @Lookup
    public PrototypeBean getPrototypeBean() {
        return null;
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("setApplicationContext method completed for bean: {}", beanName);
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
