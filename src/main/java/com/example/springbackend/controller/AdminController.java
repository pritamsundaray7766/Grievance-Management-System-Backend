package com.example.springbackend.controller;

import com.example.springbackend.model.Admin;
import com.example.springbackend.playloads.AdminDao;
import com.example.springbackend.playloads.ApiResponse;
import com.example.springbackend.playloads.UserDto;
import com.example.springbackend.repository.AdminRepository;
import com.example.springbackend.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    public ResponseEntity<List<AdminDao>> getAllAdmin() {
        return ResponseEntity.ok(this.adminService.getAllAdmin());
    }

    @GetMapping("/admins/{admin_id}")
    public  ResponseEntity<AdminDao> getAdminById(@PathVariable Long admin_id){
        return ResponseEntity.ok(this.adminService.getAdminById(admin_id));

    }

    @PostMapping("/admins")
    public ResponseEntity<AdminDao> createAdmin(@Valid @RequestBody AdminDao adminDao) {
        AdminDao createAdminDao = this.adminService.createAdmin(adminDao);
        return new ResponseEntity<>(createAdminDao, HttpStatus.CREATED);

    }

    @PutMapping("/admins/{admin_id}")
    public ResponseEntity<AdminDao> updateAdmin(@Valid @RequestBody AdminDao adminDao, @PathVariable Long admin_id) {
        AdminDao updatedAdmin = this.adminService.updateAdmin(adminDao, admin_id);
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("/admins/{admin_id}")
    public ResponseEntity<ApiResponse> deleteAdmin(@PathVariable Long admin_id) {
        this.adminService.deleteAdmin(admin_id);
        return new ResponseEntity(new ApiResponse("Admin deleted Successfully", true), HttpStatus.OK);
    }

}
