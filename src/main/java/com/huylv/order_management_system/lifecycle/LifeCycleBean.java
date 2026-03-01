package com.huylv.order_management_system.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class LifeCycleBean implements InitializingBean, DisposableBean {


    public LifeCycleBean() {
        System.out.println("1. Constructor called");
    }

    @PostConstruct
    public void postContruct() {
        System.out.println("3. @PostConstruct called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy method called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("4. afterPropertiesSet called");
    }

    public void customInit() {
        System.out.println("Custom init method called");
    }

}
