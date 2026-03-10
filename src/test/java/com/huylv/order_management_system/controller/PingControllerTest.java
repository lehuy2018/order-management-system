package com.huylv.order_management_system.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PingControllerTest {

    @Test
    void ping_returnsPong() {
        PingController controller = new PingController();
        assertEquals("pong", controller.ping());
    }
}
