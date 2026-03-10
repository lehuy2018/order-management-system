package com.huylv.order_management_system.lifecycle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LifeCycleBeanTest {

    @Test
    void postConstruct_doesNotThrow() {
        LifeCycleBean bean = new LifeCycleBean();
        assertDoesNotThrow(bean::postContruct);
    }

    @Test
    void destroy_doesNotThrow() {
        LifeCycleBean bean = new LifeCycleBean();
        assertDoesNotThrow(bean::destroy);
    }

    @Test
    void afterPropertiesSet_doesNotThrow() {
        LifeCycleBean bean = new LifeCycleBean();
        assertDoesNotThrow(bean::afterPropertiesSet);
    }

    @Test
    void customInit_doesNotThrow() {
        LifeCycleBean bean = new LifeCycleBean();
        assertDoesNotThrow(bean::customInit);
    }
}
