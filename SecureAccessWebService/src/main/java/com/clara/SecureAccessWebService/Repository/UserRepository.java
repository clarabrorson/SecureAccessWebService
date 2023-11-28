package com.clara.SecureAccessWebService.Repository;

import com.clara.SecureAccessWebService.Entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface extends the JpaRepository interface
 * It is used to perform CRUD operations on the User table
 */
@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Integer>{
    Optional<ApplicationUser> findByUsername(String username);
}
