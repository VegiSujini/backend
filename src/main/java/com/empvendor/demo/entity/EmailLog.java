package com.empvendor.demo.entity;

import  javax.persistence.*;

@Entity
public class EmailLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }



    public String getMessage() {
        return message;
    }

    private String message;

    public void setEmail(String email) {
        this.email = email.toString();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Getters and Setters
}
