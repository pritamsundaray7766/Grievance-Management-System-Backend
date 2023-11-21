package com.example.springbackend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "complaint")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long complaint_id;

//    @Column(nullable = false)
//    private String complaint_code;


    @ManyToOne
    @JoinColumn(name = "stakeholder_id")
    private Stakeholder stakeholder;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String concern;

    @Column(nullable = false)
    private String complaint_name;

    @Column(nullable = false)
    private String complaint_details;

    @Column(nullable = true)
    private String attachment;

    @Column(nullable = false)
    private Timestamp timestamp;

    @Column(nullable = false)
    private String status;
}
//    // non argument constructor
//    public Complaint(){
//
//    }
//
//    // constructor with arguments
//    public Complaint(String complaint_code, String concern, String complaint_name, String complaint_details, String attachment, Timestamp timestamp, String status) {
//        this.complaint_code = complaint_code;
//        this.concern = concern;
//        this.complaint_name = complaint_name;
//        this.complaint_details = complaint_details;
//        this.attachment = attachment;
//        this.timestamp = timestamp;
//        this.status = status;
//    }
//
//    //getter and setter
//
//    public long getComplaint_id() {
//        return complaint_id;
//    }
//
//    public void setComplaint_id(long complaint_id) {
//        this.complaint_id = complaint_id;
//    }
//
//    public String getComplaint_code() {
//        return complaint_code;
//    }
//
//    public void setComplaint_code(String complaint_code) {
//        this.complaint_code = complaint_code;
//    }
//
//    public Stakeholder getStakeholder() {
//        return stakeholder;
//    }
//
//    public void setStakeholder(Stakeholder stakeholder) {
//        this.stakeholder = stakeholder;
//    }
//
//    public String getConcern() {
//        return concern;
//    }
//
//    public void setConcern(String concern) {
//        this.concern = concern;
//    }
//
//    public String getComplaint_name() {
//        return complaint_name;
//    }
//
//    public void setComplaint_name(String complaint_name) {
//        this.complaint_name = complaint_name;
//    }
//
//    public String getComplaint_details() {
//        return complaint_details;
//    }
//
//    public void setComplaint_details(String complaint_details) {
//        this.complaint_details = complaint_details;
//    }
//
//    public String getAttachment() {
//        return attachment;
//    }
//
//    public void setAttachment(String attachment) {
//        this.attachment = attachment;
//    }
//
//    public Timestamp getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Timestamp timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    //toString
//    @Override
//    public String toString() {
//        return "Complaint{" +
//                "complaint_id=" + complaint_id +
//                ", complaint_code='" + complaint_code + '\'' +
//                ", stakeholder=" + stakeholder +
//                ", user=" + user +
//                ", concern='" + concern + '\'' +
//                ", complaint_name='" + complaint_name + '\'' +
//                ", complaint_details='" + complaint_details + '\'' +
//                ", attachment='" + attachment + '\'' +
//                ", timestamp=" + timestamp +
//                ", status='" + status + '\'' +
//                '}';
//    }
//}
