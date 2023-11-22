package com.example.springbackend.playloads;

import com.example.springbackend.model.Complaint;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
public class ComplaintDetailsDao {
    private long complaint_dtls_id;

    private Complaint complaint;


    private String complaint_code;


    private String complete_name;


    private String update_message;


    private Date date_processed;


    private String replay_from_complaint;


    private String status;
}
