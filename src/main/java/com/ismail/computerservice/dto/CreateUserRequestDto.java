package com.ismail.computerservice.dto;

import com.ismail.computerservice.model.Role;

import java.util.Set;

public class CreateUserRequestDto {

    private String username;
    private String email;
    private String password;
    private Set<Role> roles;



    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    // private constructor to force the use of the builder
    private CreateUserRequestDto() {

    }


}
