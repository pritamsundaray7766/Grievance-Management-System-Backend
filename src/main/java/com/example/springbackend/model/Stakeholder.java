package com.example.springbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stakeholder")
public class Stakeholder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stakeholder_id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = true)
    private String middle_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String stakeholder_type;

    @Column(nullable = false)
    private int contact;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String account_status;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public Stakeholder(){

    }

    public Stakeholder(String first_name, String middle_name, String last_name, String stakeholder_type, int contact, String email, String user_name, String password, String account_status) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.stakeholder_type = stakeholder_type;
        this.contact = contact;
        this.email = email;
        this.user_name = user_name;
        this.password = password;
        this.account_status = account_status;
    }


    //getter and setter
    public long getStakeholder_id() {
        return stakeholder_id;
    }

    public void setStakeholder_id(long stakeholder_id) {
        this.stakeholder_id = stakeholder_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStakeholder_type() {
        return stakeholder_type;
    }

    public void setStakeholder_type(String stakeholder_type) {
        this.stakeholder_type = stakeholder_type;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Stakeholder{" +
                "stakeholder_id=" + stakeholder_id +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", stakeholder_type='" + stakeholder_type + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", account_status='" + account_status + '\'' +
                ", admin=" + admin +
                '}';
    }
}
