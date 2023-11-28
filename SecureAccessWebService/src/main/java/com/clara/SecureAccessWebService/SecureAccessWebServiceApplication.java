package com.clara.SecureAccessWebService;

import com.clara.SecureAccessWebService.Entity.ApplicationUser;
import com.clara.SecureAccessWebService.Entity.Role;
import com.clara.SecureAccessWebService.Repository.RoleRepository;
import com.clara.SecureAccessWebService.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

/**
 * This class is the main class of the application
 * It is annotated with @SpringBootApplication which makes it a Spring Boot application
 * CommandLineRunner is an interface that is used to run code at startup of the application
 */
@SpringBootApplication
public class SecureAccessWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureAccessWebServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncode){
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncode.encode("password"), roles);

			userRepository.save(admin);
		};
	}
}
