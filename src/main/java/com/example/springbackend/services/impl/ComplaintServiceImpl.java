package com.example.springbackend.services.impl;

import com.example.springbackend.exception.ResourceNotFoundException;
import com.example.springbackend.model.Complaint;
import com.example.springbackend.playloads.ComplaintDao;
import com.example.springbackend.repository.ComplaintRepository;
import com.example.springbackend.services.ComplaintService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ComplaintDao createComplaint(ComplaintDao complaintDao) {
        Complaint complaint =this.daoToComplaint(complaintDao);
        // Set the timestamp field with the current date and time
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        complaint.setTimestamp(currentTimestamp);
        Complaint savedComplaint = this.complaintRepository.save(complaint);
        return this.complaintToDao(savedComplaint);
    }

    @Override
    public ComplaintDao updateComplaint(ComplaintDao complaintDao, Long complaint_id) {
        Complaint complaint = this.complaintRepository.findById(complaint_id).orElseThrow(()-> new ResourceNotFoundException("Complaint","id",complaint_id));
        complaint.setConcern(complaintDao.getConcern());
        complaint.setComplaint_name(complaintDao.getComplaint_name());
        complaint.setComplaint_details(complaintDao.getComplaint_details());
//        complaint.setContact((int) adminDao.getContact());
        complaint.setAttachment(complaintDao.getAttachment());
        complaint.setStatus(complaintDao.getStatus());
        complaint.setTimestamp(complaintDao.getTimestamp());

        Complaint updateComplaint = this.complaintRepository.save(complaint);
        ComplaintDao complaintDao1 = this.complaintToDao(updateComplaint);
        return complaintDao1;
    }

    @Override
    public ComplaintDao getComplaintById(Long complaint_id) {
        Complaint complaint = this.complaintRepository.findById(complaint_id).orElseThrow(()->new ResourceNotFoundException("Complaint", "id", complaint_id));

        return this.complaintToDao(complaint);
    }

    @Override
    public List<ComplaintDao> getAllComplaint() {
        List<Complaint> complaints = this.complaintRepository.findAll();
        List<ComplaintDao> complaintDaos = complaints.stream().map(complaint -> this.complaintToDao(complaint)).collect(Collectors.toList());
        return complaintDaos;
    }

    @Override
    public void deleteComplaint(Long complaint_id) {
        Complaint complaint= this.complaintRepository.findById(complaint_id).orElseThrow(()-> new ResourceNotFoundException("Complaint", "id", complaint_id));
        this.complaintRepository.delete(complaint);
    }

    public Complaint daoToComplaint(ComplaintDao complaintDao){
        Complaint complaint = this.modelMapper.map(complaintDao, Complaint.class);
        return complaint;
    }

    public ComplaintDao complaintToDao(Complaint complaint){
        ComplaintDao complaintDao = this.modelMapper.map(complaint, ComplaintDao.class);
        return complaintDao;
    }


}
