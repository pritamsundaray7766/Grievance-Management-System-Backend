package com.example.springbackend.services;

import com.example.springbackend.playloads.ComplaintDao;
import com.example.springbackend.playloads.ComplaintDetailsDao;

import java.util.List;

public interface ComplaintDetailsService {
    ComplaintDetailsDao createComplaintDetails(ComplaintDetailsDao complaint_dtls);
    ComplaintDetailsDao updateComplaintDetails(ComplaintDetailsDao complaint_dtls,Long complaint_dtls_id);
    ComplaintDetailsDao  getComplaintDetailsById(Long complaint_dtls_id);
    List<ComplaintDetailsDao> getAllComplaintDetails();
    void deleteComplaintDetails(Long complaint_dtls_id);

}
