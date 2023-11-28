package com.clara.SecureAccessWebService.Service;

import com.clara.SecureAccessWebService.Entity.ApplicationUser;
import com.clara.SecureAccessWebService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * This class is a service class that handles user details
 * It implements the UserDetailsService interface that is used to load user-specific data
 * It contains methods that return user details and users
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("In the user details service");
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }
    public ApplicationUser getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }
    public Iterable<ApplicationUser> getUsers() {
        return userRepository.findAll();
    }
}
