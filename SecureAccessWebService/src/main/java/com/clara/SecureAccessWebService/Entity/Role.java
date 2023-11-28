package com.clara.SecureAccessWebService.Entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

/**
 * This class is an entity class that represents a role in the database
 * It is used to create roles for users
 * There are two roles: ROLE_USER and ROLE_ADMIN
 * GrantedAuthority is an interface used to represent an authority and is a part of Spring Security
 */
@Entity
@Table(name="roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="role_id")
    private Integer roleId;

    private String authority;

    public Role(){
        super();
    }

    public Role(String authority){
        this.authority = authority;
    }

    public Role(Integer roleId, String authority){
        this.roleId = roleId;
        this.authority = authority;
    }
    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return this.authority;
    }
    public void setAuthority(String authority){
        this.authority = authority;
    }

    public Integer getRoleId(){
        return this.roleId;
    }

    public void setRoleId(Integer roleId){
        this.roleId = roleId;
    }
}