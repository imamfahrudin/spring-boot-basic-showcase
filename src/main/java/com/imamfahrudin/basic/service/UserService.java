package com.imamfahrudin.basic.service;

import com.imamfahrudin.basic.entity.User;
import com.imamfahrudin.basic.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class for user-related operations.
 * Handles user creation, persistence, and retrieval with transactional support.
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final String applicationName;

    /**
     * Constructor-based dependency injection.
     * Spring automatically injects the UserRepository bean and the applicationName String bean
     * defined in AppConfig into this service.
     * @param userRepository the JPA repository for User entities
     * @param applicationName the application name from configuration
     */
    public UserService(UserRepository userRepository, String applicationName) {
        this.userRepository = userRepository;
        this.applicationName = applicationName;
    }

    /**
     * Saves a new user with the given name.
     * Creates a user entity with username and generated email, then persists it.
     * @param name the username for the new user
     */
    public void saveUser(String name) {
        User user = new User();
        user.setUsername(name);
        user.setEmail(name + "@example.com");
        userRepository.save(user);
        System.out.println("Saved " + name + " to " + applicationName);
    }

    /**
     * Saves a user with intentional rollback demonstration.
     * Persists the user but then throws a RuntimeException to trigger transaction rollback.
     * @param name the username for the user
     * @throws RuntimeException always thrown to demonstrate rollback
     */
    @Transactional
    public void saveUserWithRollback(String name) {
        User user = new User();
        user.setUsername(name);
        user.setEmail(name + "@example.com");
        userRepository.save(user);
        throw new RuntimeException("Simulated Error for Rollback");
    }

    /**
     * Retrieves all users from the database.
     * @return list of all persisted users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}