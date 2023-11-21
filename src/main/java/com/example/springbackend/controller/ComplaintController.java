package com.example.springbackend.controller;


import com.example.springbackend.model.Admin;
import com.example.springbackend.model.Complaint;
import com.example.springbackend.playloads.AdminDao;
import com.example.springbackend.playloads.ApiResponse;
import com.example.springbackend.playloads.ComplaintDao;
import com.example.springbackend.playloads.ImageResponse;
import com.example.springbackend.repository.ComplaintRepository;
import com.example.springbackend.services.ComplaintService;
import com.example.springbackend.services.FileService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private FileService fileService;
    @Value("${project.image}")
    private String path;

    @GetMapping("/complaints")
    public ResponseEntity<List<ComplaintDao>> getAllComplaint() {
        return ResponseEntity.ok(this.complaintService.getAllComplaint());
    }


    @GetMapping("/complaints/{complaint_id}")
    public  ResponseEntity<ComplaintDao> getComplaintById(@PathVariable Long complaint_id){
        return ResponseEntity.ok(this.complaintService.getComplaintById(complaint_id));

    }

    @PostMapping("/complaints")
    public ResponseEntity<ComplaintDao> createComplaint(@Valid @RequestBody ComplaintDao complaintDao) {
        ComplaintDao createComplaintDao = this.complaintService.createComplaint(complaintDao);
        return new ResponseEntity<>(createComplaintDao, HttpStatus.CREATED);

    }

    @PutMapping("/complaints/{complaint_id}")
    public ResponseEntity<ComplaintDao> updateComplaint(@Valid @RequestBody ComplaintDao complaintDao, @PathVariable Long complaint_id) {
        ComplaintDao updatedComplaint = this.complaintService.updateComplaint(complaintDao, complaint_id);
        return ResponseEntity.ok(updatedComplaint);
    }


    @DeleteMapping("/complaints/{complaint_id}")
    public ResponseEntity<ApiResponse> deleteComplaint(@PathVariable Long complaint_id){
        this.complaintService.deleteComplaint(complaint_id);
        return new ResponseEntity(new ApiResponse("Complaint deleted successfully", true), HttpStatus.OK);
    }

    // complaint image upload
    @PostMapping("/complaints/image/upload/{complaint_id}")
    public ResponseEntity<ComplaintDao> uploadpostImage(
            @RequestParam("image")MultipartFile image,
            @PathVariable Long complaint_id) throws IOException {

        ComplaintDao complaintDao= this.complaintService.getComplaintById(complaint_id);
        String fileName=this.fileService.uploadImage(path, image);
        complaintDao.setAttachment(fileName);
        ComplaintDao updateComplaint = this.complaintService.updateComplaint(complaintDao, complaint_id);
        return new ResponseEntity<ComplaintDao>(updateComplaint, HttpStatus.OK);

    }

    // method to serve files
    @GetMapping(value = "/complaints/image/{Attachment}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@PathVariable("Attachment") String Attachment, HttpServletResponse response) throws IOException{
        InputStream resource = this.fileService.getResource(path, Attachment);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());

    }

}
