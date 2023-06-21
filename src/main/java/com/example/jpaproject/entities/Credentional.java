package com.example.jpaproject.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Credentional {
    private String email;
    private String password;

    public Credentional(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Credentional() {
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

    @Override
    public String toString() {
        return "Credentional{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

