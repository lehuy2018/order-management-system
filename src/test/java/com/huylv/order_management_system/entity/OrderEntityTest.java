package com.huylv.order_management_system.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderEntityTest {

    @Test
    void defaultConstructor_createsEntityWithNullFields() {
        OrderEntity entity = new OrderEntity();
        assertNull(entity.getId());
        assertNull(entity.getName());
    }

    @Test
    void nameConstructor_setsName() {
        OrderEntity entity = new OrderEntity("ORDER-1");
        assertEquals("ORDER-1", entity.getName());
        assertNull(entity.getId());
    }

    @Test
    void setId_updatesId() {
        OrderEntity entity = new OrderEntity();
        entity.setId(42L);
        assertEquals(42L, entity.getId());
    }

    @Test
    void setName_updatesName() {
        OrderEntity entity = new OrderEntity();
        entity.setName("ORDER-2");
        assertEquals("ORDER-2", entity.getName());
    }
}
