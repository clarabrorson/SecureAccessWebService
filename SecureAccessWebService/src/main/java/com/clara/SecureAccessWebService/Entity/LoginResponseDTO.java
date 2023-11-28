package com.clara.SecureAccessWebService.Entity;

/**
 * This class is used to send the user's information and JWT-token back to the client
 */
public class LoginResponseDTO {
    private ApplicationUser user;
    private String jwt;

    public LoginResponseDTO(){
        super();
    }
    public LoginResponseDTO(ApplicationUser user, String jwt){
        this.user = user;
        this.jwt = jwt;
    }

    public ApplicationUser getUser(){
        return this.user;
    }

    public void setUser(ApplicationUser user){
        this.user = user;
    }

    public String getJwt(){
        return this.jwt;
    }

    public void setJwt(String jwt){
        this.jwt = jwt;
    }
}
