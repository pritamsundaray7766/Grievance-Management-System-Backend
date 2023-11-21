package com.example.springbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long admin_id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = true)
    private String middle_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private long contact;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String account_status;

//    // Non argument constructor
//    public Admin(){
//
//    }
//
//    // constructor with argument
//
//    public Admin(String first_name, String middle_name, String last_name, String role, int contact, String email, String user_name, String password, String account_status) {
//        this.first_name = first_name;
//        this.middle_name = middle_name;
//        this.last_name = last_name;
//        this.role = role;
//        this.contact = contact;
//        this.email = email;
//        this.user_name = user_name;
//        this.password = password;
//        this.account_status = account_status;
//    }
//
//    // Getter and setter
//
//    public long getAdmin_id() {
//        return admin_id;
//    }
//
//    public void setAdmin_id(long admin_id) {
//        this.admin_id = admin_id;
//    }
//
//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getMiddle_name() {
//        return middle_name;
//    }
//
//    public void setMiddle_name(String middle_name) {
//        this.middle_name = middle_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public int getContact() {
//        return contact;
//    }
//
//    public void setContact(int contact) {
//        this.contact = contact;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUser_name() {
//        return user_name;
//    }
//
//    public void setUser_name(String user_name) {
//        this.user_name = user_name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getAccount_status() {
//        return account_status;
//    }
//
//    public void setAccount_status(String account_status) {
//        this.account_status = account_status;
//    }
//
//    //toString
//
//    @Override
//    public String toString() {
//        return "Admin{" +
//                "admin_id=" + admin_id +
//                ", first_name='" + first_name + '\'' +
//                ", middle_name='" + middle_name + '\'' +
//                ", last_name='" + last_name + '\'' +
//                ", role='" + role + '\'' +
//                ", contact=" + contact +
//                ", email='" + email + '\'' +
//                ", user_name='" + user_name + '\'' +
//                ", password='" + password + '\'' +
//                ", account_status='" + account_status + '\'' +
//                '}';
//    }
}
