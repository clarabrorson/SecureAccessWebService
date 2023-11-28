package com.clara.SecureAccessWebService.Service;

import com.clara.SecureAccessWebService.Entity.ApplicationUser;
import com.clara.SecureAccessWebService.Entity.Role;
import com.clara.SecureAccessWebService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * This class is a service class that handles admin related operations
 * The class is autowired with UserRepository to access the database
 */
@Service
public class AdminService {
    @Autowired
    private UserRepository userRepository;

    public ApplicationUser getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }
    public Iterable<ApplicationUser> getUsers() {
        return userRepository.findAll();
    }
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User deleted";
    }
    public ApplicationUser updateUser(ApplicationUser user) {
        ApplicationUser existingUser = userRepository.findById(user.getUserId()).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setAuthorities((Set<Role>) user.getAuthorities());
            return userRepository.save(existingUser);

        } else {
            return null;
        }
    }
}
