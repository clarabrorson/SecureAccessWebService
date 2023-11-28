package com.clara.SecureAccessWebService.Controllers;

import com.clara.SecureAccessWebService.Entity.ApplicationUser;
import com.clara.SecureAccessWebService.Entity.LoginResponseDTO;
import com.clara.SecureAccessWebService.Entity.RegistrationDTO;
import com.clara.SecureAccessWebService.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This class is the controller for the authentication.
 * The authentication is used to register and login users.
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }

}
