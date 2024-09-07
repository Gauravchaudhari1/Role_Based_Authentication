package com.Security_Registration_App.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String mobilNo;
    private String password;
    @Column(name = "role")
    private String role;

    public Parent() {
    }

    public Parent(int id, String name, String email, String mobilNo, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobilNo = mobilNo;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilNo() {
        return mobilNo;
    }

    public void setMobilNo(String mobilNo) {
        this.mobilNo = mobilNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Parent [id=" + id + ", name=" + name + ", email=" + email + ", mobilNo=" + mobilNo + ", password="
                + password + ", role=" + role + "]";
    }

}
