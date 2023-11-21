package com.example.springbackend.controller;


import com.example.springbackend.model.ComplaintDetails;
import com.example.springbackend.playloads.ApiResponse;
import com.example.springbackend.playloads.ComplaintDao;
import com.example.springbackend.playloads.ComplaintDetailsDao;
import com.example.springbackend.repository.ComplaintDetailsRepository;
import com.example.springbackend.services.ComplaintDetailsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ComplaintDetailsController {
    @Autowired
    public ComplaintDetailsService complaintDetailsService;

//    @GetMapping
//    public ResponseEntity<List<ComplaintDetailsDao>> getAllComplaintDetails() {
//        return ResponseEntity.ok(this.complaintDetailsService.getAllComplaintDetails());
//    }
//
//    @GetMapping("/complaints/{complaint_dtls_id}")
//    public ComplaintDetails getComplaintDetailsById(@PathVariable Long complaint_dtls_id) {
//        return complaintDetailsRepository.findById(complaint_dtls_id).get();
//    }
//
//    @PostMapping("/complaintDetails")
//    public ComplaintDetails saveComplaintDetails(@RequestBody ComplaintDetails complaintDetails) {
//        return complaintDetailsRepository.save(complaintDetails);
//    }
//
//
//    @PutMapping("/complaintDetails")
//    public ComplaintDetails updateComplaintDetails(@RequestBody ComplaintDetails complaintDetails) {
//
//        return complaintDetailsRepository.save(complaintDetails);
//    }
//
//    @DeleteMapping("/complaintDetails/{complaint_dtls_id}")
//    public ResponseEntity<HttpStatus> deleteComplaintDetailsById(@PathVariable Long complaint_dtls_id) {
//        complaintDetailsRepository.deleteById(complaint_dtls_id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
    // new
    @GetMapping("/complaintDetails")
    public ResponseEntity<List<ComplaintDetailsDao>> getAllComplaintDetails() {
        return ResponseEntity.ok(this.complaintDetailsService.getAllComplaintDetails());
    }


    @GetMapping("/complaintDetails/{complaint_dtls_id}")
    public  ResponseEntity<ComplaintDetailsDao> getComplaintDetailsById(@PathVariable Long complaint_dtls_id){
        return ResponseEntity.ok(this.complaintDetailsService.getComplaintDetailsById(complaint_dtls_id));

    }

    @PostMapping("/complaintDetails")
    public ResponseEntity<ComplaintDetailsDao> createComplaintDetails(@Valid @RequestBody ComplaintDetailsDao complaintDetailsDao) {
        ComplaintDetailsDao createComplaintDao = this.complaintDetailsService.createComplaintDetails(complaintDetailsDao);
        return new ResponseEntity<>(createComplaintDao, HttpStatus.CREATED);

    }

    @PutMapping("/complaintDetails/{complaint_dtls_id}")
    public ResponseEntity<ComplaintDetailsDao> updateComplaintDetails(@Valid @RequestBody ComplaintDetailsDao complaintDetailsDao, @PathVariable Long complaint_dtls_id) {
        ComplaintDetailsDao updatedComplaintDetalis = this.complaintDetailsService.updateComplaintDetails(complaintDetailsDao, complaint_dtls_id);
        return ResponseEntity.ok(updatedComplaintDetalis);
    }


    @DeleteMapping("/complaintDetails/{complaint_dtls_id}")
    public ResponseEntity<ApiResponse> deleteComplaintDetails(@PathVariable Long complaint_dtls_id){
        this.complaintDetailsService.deleteComplaintDetails(complaint_dtls_id);
        return new ResponseEntity(new ApiResponse("Complaint deleted successfully", true), HttpStatus.OK);
    }
}
