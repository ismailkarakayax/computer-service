package com.ismail.computerservice.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"ROLES\"")
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "rolename")
    private String name;


    public Role(String name) {
        this.name = name;
    }
    public Role() {
    }

    @Override
    public String getAuthority() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}