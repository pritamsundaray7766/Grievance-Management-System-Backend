package com.example.springbackend.services;

import com.example.springbackend.playloads.ComplaintDao;

import java.util.List;

public interface ComplaintService {

    ComplaintDao createComplaint(ComplaintDao complaint);
    ComplaintDao updateComplaint(ComplaintDao complaint,Long complaint_id);
    ComplaintDao  getComplaintById(Long complaint_id);
    List<ComplaintDao> getAllComplaint();
    void deleteComplaint(Long complaint_id);
}
