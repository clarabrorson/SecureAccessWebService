package com.clara.SecureAccessWebService.Entity;

/**
 * This class is a DTO (Data Transfer Object) that is used to transfer data between the client and the server
 * DTOs are used to reduce the number of calls needed to transfer data between client and server
 */
public class RegistrationDTO {
    private String username;
    private String password;

    public RegistrationDTO(){
        super();
    }
    public RegistrationDTO(String username, String password){
        super();
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String toString(){
        return "Registration info: username: " + this.username + " password: " + this.password;
    }
}
