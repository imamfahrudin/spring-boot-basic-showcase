package com.imamfahrudin.basic.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AppConfigTest {

    @Autowired
    private String applicationName;

    @Test
    public void testApplicationNameBean() {
        assertNotNull(applicationName, "Application name bean should be created");
        assertEquals("Imam's Spring Showcase", applicationName, "Application name should match expected value");
    }
}