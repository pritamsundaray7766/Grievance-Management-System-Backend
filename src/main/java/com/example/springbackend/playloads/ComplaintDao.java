package com.example.springbackend.playloads;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
public class ComplaintDao {
    private long complaint_id;

    @Size(min = 4,message = "Title is needed & must be min of 5 characters !!")
    private String concern;

    @Size(message = "choose from the drop down list")
    private String complaint_name;

    @Size(min = 1, max = 255,message = "Describe your complain")
    private String complaint_details;

    private String attachment;
    @Column(name = "timestamp")
    private Timestamp timestamp;


    private String status;
}
