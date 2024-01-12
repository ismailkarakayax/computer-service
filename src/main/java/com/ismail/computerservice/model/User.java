package com.ismail.computerservice.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"USERS\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "\"AUTHORITIES\"",
            joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(name = "authority")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<SaleLog> saleLogs;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Proposal> proposals;



    public User() {

    }

    public User(Long id, String username, String email, String password, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public static class Builder {

        private final User user;

        public Builder() {
            user = new User();
        }

        public Builder username(String username) {
            user.username = username;
            return this;
        }

        public Builder email(String email) {
            user.email = email;
            return this;
        }

        public Builder password(String password) {
            user.password = password;
            return this;
        }

        public Builder roles(Set<Role> roles) {
            user.roles = roles;
            return this;
        }

        public User build() {
            return user;
        }
    }
}
