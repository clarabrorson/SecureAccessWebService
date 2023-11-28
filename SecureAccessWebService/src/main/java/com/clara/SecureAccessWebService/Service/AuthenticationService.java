package com.clara.SecureAccessWebService.Service;

import com.clara.SecureAccessWebService.Entity.ApplicationUser;
import com.clara.SecureAccessWebService.Entity.LoginResponseDTO;
import com.clara.SecureAccessWebService.Entity.Role;
import com.clara.SecureAccessWebService.Repository.RoleRepository;
import com.clara.SecureAccessWebService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * This class is a service class that handles authentication
 * @Transactional is an annotation that says that all methods in the class should run in a transaction
 * A transaction is a group of operations that should run as a unit
 * All operations in the transaction must run successfully for the transaction to be successful
 * If one operation in the transaction fails, all operations in the transaction will be rolled back
 * This is to ensure that the database is in a consistent state
 */
@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public ApplicationUser registerUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").orElse(null);

        Set<Role> authorities = new HashSet<>();

        if (userRole != null) {
            authorities.add(userRole);
        }
        ApplicationUser newUser = new ApplicationUser(null, username, encodedPassword, authorities);
        return userRepository.save(newUser);
    }
    public LoginResponseDTO loginUser(String username, String password) {

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);
            return new LoginResponseDTO(userRepository.findByUsername(username).orElse(null), token);

        } catch (AuthenticationException e) {
            return new LoginResponseDTO(null, "");
        }
    }
}
