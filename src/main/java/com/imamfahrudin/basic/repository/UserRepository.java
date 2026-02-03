package com.imamfahrudin.basic.repository;

import com.imamfahrudin.basic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for User entity operations.
 * Provides CRUD operations and query methods for User entities.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}