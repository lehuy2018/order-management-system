package com.huylv.order_management_system.lifecycle;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) {
        if (bean instanceof LifeCycleBean) {
            System.out.println("2. postProcessBeforeInitialization called for: " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) {
        if (bean instanceof LifeCycleBean) {
            System.out.println("5. postProcessAfterInitialization called for: " + beanName);
        }
        return bean;
    }
}
