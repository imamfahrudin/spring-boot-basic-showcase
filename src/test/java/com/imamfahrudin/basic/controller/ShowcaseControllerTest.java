package com.imamfahrudin.basic.controller;

import com.imamfahrudin.basic.entity.User;
import com.imamfahrudin.basic.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ShowcaseControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private ShowcaseController controller;

    @Test
    public void testSaveUser() {
        // Given
        String name = "testUser";
        doNothing().when(userService).saveUser(name);

        // When
        String result = controller.saveUser(name);

        // Then
        assertEquals("User saved successfully", result);
        verify(userService, times(1)).saveUser(name);
    }

    @Test
    public void testSaveUserWithRollback() {
        // Given
        String name = "testUser";
        doThrow(new RuntimeException("Simulated Error for Rollback")).when(userService).saveUserWithRollback(name);

        // When
        String result = controller.saveUserWithRollback(name);

        // Then
        assertEquals("Exception caught, check DB to confirm rollback", result);
        verify(userService, times(1)).saveUserWithRollback(name);
    }

    @Test
    public void testSaveUserWithRollbackNoException() {
        // Given
        String name = "testUser";
        doNothing().when(userService).saveUserWithRollback(name); // Mock to not throw

        // When
        String result = controller.saveUserWithRollback(name);

        // Then
        assertEquals("Should not reach here", result);
        verify(userService, times(1)).saveUserWithRollback(name);
    }

    @Test
    public void testGetAllUsers() {
        // Given
        User user1 = new User(1L, "user1", "user1@example.com");
        User user2 = new User(2L, "user2", "user2@example.com");
        List<User> users = Arrays.asList(user1, user2);
        when(userService.getAllUsers()).thenReturn(users);

        // When
        List<User> result = controller.getAllUsers();

        // Then
        assertEquals(users, result);
        verify(userService, times(1)).getAllUsers();
    }
}