package com.huylv.order_management_system.lifecycle;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof LifeCycleBean) {
            System.out.println("2. postProcessBeforeInitialization called for: " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof LifeCycleBean) {
            System.out.println("5. postProcessAfterInitialization called for: " + beanName);
        }
        return bean;
    }
}
