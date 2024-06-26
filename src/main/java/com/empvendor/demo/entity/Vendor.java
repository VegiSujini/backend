package com.empvendor.demo.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor {

    @Id
    private String email;
    private String name;
    private String upi;

    public String getName() {
        return  this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUpi() {
        return  this.upi;
    }

    // Getters and Setters
}
