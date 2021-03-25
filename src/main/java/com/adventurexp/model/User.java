package com.adventurexp.model;

import javax.persistence.*;

@Entity
@Table (name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "username")
    private String username;

    @Column
    private String password;

    @Column
    private Boolean enabled;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getEnabled() {
        return enabled;
    }
}
