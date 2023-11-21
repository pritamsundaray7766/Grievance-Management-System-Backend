package com.example.springbackend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    @Column( nullable = false, length = 100)
    private String first_name;
    private String middle_name;
    private String last_name;
    @Column(nullable = false)
    private long contact;
    private String email;
    @Column( nullable = false)
    private String password;


//
//    @Column(nullable = false)
//    private String account_status;


    //Getter and Setter


//    public long getDept_user_id() {
//        return user_id;
//    }
//
//    public void setDept_user_id(long dept_user_id) {
//        this.user_id = dept_user_id;
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
//
//
//    public long getContact() {
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
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
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
//
//    // creating constructor with arguments
//
//    public User(String first_name, String middle_name, String last_name, int contact, String email, String password, String role) {
//        this.first_name = first_name;
//        this.middle_name = middle_name;
//        this.last_name = last_name;
//        this.contact = contact;
//        this.email = email;
//        this.password = password;
//        this.role=role;
//    }
//
//    //Creating toString method
//    @Override
//    public String toString() {
//        return "User{" +
//                "user_id=" + user_id +
//                ", first_name='" + first_name + '\'' +
//                ", middle_name='" + middle_name + '\'' +
//                ", last_name='" + last_name + '\'' +
//                ", contact=" + contact +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", role='" + role + '\'' +
//                '}';
//    }
}
