package com.imamfahrudin.basic.controller;

import com.imamfahrudin.basic.entity.User;
import com.imamfahrudin.basic.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for basic Spring Boot showcase operations.
 * Provides endpoints for user management including saving, rollback demonstration, and retrieval.
 */
@RestController
@RequestMapping("/api/basic")
public class ShowcaseController {

    private final UserService userService;

    public ShowcaseController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Saves a new user with the given name.
     * @param name the username for the new user
     * @return success message indicating the user was saved
     */
    @PostMapping("/save")
    public String saveUser(@RequestParam String name) {
        userService.saveUser(name);
        return "User saved successfully";
    }

    /**
     * Demonstrates transactional rollback by attempting to save a user and then throwing an exception.
     * @param name the username for the user attempt
     * @return message indicating exception was caught and rollback should be confirmed
     */
    @PostMapping("/rollback")
    public String saveUserWithRollback(@RequestParam String name) {
        try {
            userService.saveUserWithRollback(name);
            return "Should not reach here";
        } catch (RuntimeException e) {
            return "Exception caught, check DB to confirm rollback";
        }
    }

    /**
     * Retrieves all users from the database.
     * @return list of all users
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}