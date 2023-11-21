package com.example.springbackend.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "complaint_dtls")
public class ComplaintDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long complaint_dtls_id;

    @ManyToOne
    @JoinColumn(name = "complaint_id")
    private Complaint complaint;

    @Column(nullable = false)
    private String complaint_code;

    @Column(nullable = false)
    private String complete_name;

    @Column(nullable = false)
    private String update_message;

    @Column(nullable = false)
    private Date date_processed;

    @Column(nullable = true)
    private String replay_from_complaint;

    @Column(nullable = false)
    private String status;

    //non argument constructor
    public ComplaintDetails(){

    }

    // constructor with argument

    public ComplaintDetails(Complaint complaint, String complaint_code, String complete_name, String update_message, Date date_processed, String replay_from_complaint, String status) {
        this.complaint = complaint;
        this.complaint_code = complaint_code;
        this.complete_name = complete_name;
        this.update_message = update_message;
        this.date_processed = date_processed;
        this.replay_from_complaint = replay_from_complaint;
        this.status = status;
    }

    //getter and setter

    public long getComplaint_dtls_id() {
        return complaint_dtls_id;
    }

    public void setComplaint_dtls_id(long complaint_dtls_id) {
        this.complaint_dtls_id = complaint_dtls_id;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public String getComplaint_code() {
        return complaint_code;
    }

    public void setComplaint_code(String complaint_code) {
        this.complaint_code = complaint_code;
    }

    public String getComplete_name() {
        return complete_name;
    }

    public void setComplete_name(String complete_name) {
        this.complete_name = complete_name;
    }

    public String getUpdate_message() {
        return update_message;
    }

    public void setUpdate_message(String update_message) {
        this.update_message = update_message;
    }

    public Date getDate_processed() {
        return date_processed;
    }

    public void setDate_processed(Date date_processed) {
        this.date_processed = date_processed;
    }

    public String getReplay_from_complaint() {
        return replay_from_complaint;
    }

    public void setReplay_from_complaint(String replay_from_complaint) {
        this.replay_from_complaint = replay_from_complaint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //toString

    @Override
    public String toString() {
        return "ComplaintDetails{" +
                "complaint_dtls_id=" + complaint_dtls_id +
                ", complaint=" + complaint +
                ", complaint_code='" + complaint_code + '\'' +
                ", complete_name='" + complete_name + '\'' +
                ", update_message='" + update_message + '\'' +
                ", date_processed=" + date_processed +
                ", replay_from_complaint='" + replay_from_complaint + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
