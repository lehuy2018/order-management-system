package com.huylv.order_management_system.lifecycle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomBeanPostProcessorTest {

    private final CustomBeanPostProcessor processor = new CustomBeanPostProcessor();

    @Test
    void postProcessBeforeInitialization_withLifeCycleBean_returnsSameBean() {
        LifeCycleBean bean = new LifeCycleBean();
        Object result = processor.postProcessBeforeInitialization(bean, "lifeCycleBean");
        assertSame(bean, result);
    }

    @Test
    void postProcessBeforeInitialization_withOtherBean_returnsSameBean() {
        Object bean = new Object();
        Object result = processor.postProcessBeforeInitialization(bean, "someBean");
        assertSame(bean, result);
    }

    @Test
    void postProcessAfterInitialization_withLifeCycleBean_returnsSameBean() {
        LifeCycleBean bean = new LifeCycleBean();
        Object result = processor.postProcessAfterInitialization(bean, "lifeCycleBean");
        assertSame(bean, result);
    }

    @Test
    void postProcessAfterInitialization_withOtherBean_returnsSameBean() {
        Object bean = new Object();
        Object result = processor.postProcessAfterInitialization(bean, "someBean");
        assertSame(bean, result);
    }
}
