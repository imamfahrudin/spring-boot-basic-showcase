package com.imamfahrudin.basic.aspect;

import com.imamfahrudin.basic.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class LoggingAspectTest {

    @Autowired
    private UserService userService;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testLogBeforeService() {
        // When
        userService.saveUser("testUser");

        // Then
        String output = outputStream.toString();
        assertTrue(output.contains(">>> AOP: Entering method in Service Layer"),
                "Aspect should log before service method execution");
        assertTrue(output.contains("Saved testUser to"),
                "Service should print save message");
    }
}