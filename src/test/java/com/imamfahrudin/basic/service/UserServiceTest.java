package com.imamfahrudin.basic.service;

import com.imamfahrudin.basic.entity.User;
import com.imamfahrudin.basic.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @Test
    public void testSaveUser() {
        // Given
        userService = new UserService(userRepository, "Test App");
        String name = "testUser";

        // When
        userService.saveUser(name);

        // Then
        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(1)).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();
        assertEquals(name, savedUser.getUsername());
        assertEquals(name + "@example.com", savedUser.getEmail());
    }

    @Test
    public void testSaveUserWithRollback() {
        // Given
        userService = new UserService(userRepository, "Test App");
        String name = "testUser";

        // When & Then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.saveUserWithRollback(name);
        });
        assertEquals("Simulated Error for Rollback", exception.getMessage());

        // Verify that save was called before the exception
        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(1)).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();
        assertEquals(name, savedUser.getUsername());
        assertEquals(name + "@example.com", savedUser.getEmail());
    }

    @Test
    public void testGetAllUsers() {
        // Given
        userService = new UserService(userRepository, "Test App");
        User user1 = new User(1L, "user1", "user1@example.com");
        User user2 = new User(2L, "user2", "user2@example.com");
        List<User> users = Arrays.asList(user1, user2);
        when(userRepository.findAll()).thenReturn(users);

        // When
        List<User> result = userService.getAllUsers();

        // Then
        assertEquals(users, result);
        verify(userRepository, times(1)).findAll();
    }
}