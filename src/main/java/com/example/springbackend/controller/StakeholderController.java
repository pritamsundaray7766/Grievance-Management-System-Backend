package com.example.springbackend.controller;


import com.example.springbackend.model.Stakeholder;
import com.example.springbackend.playloads.ApiResponse;
import com.example.springbackend.playloads.ComplaintDao;
import com.example.springbackend.playloads.ComplaintDetailsDao;
import com.example.springbackend.playloads.StakeholderDao;
import com.example.springbackend.repository.StakeholderRepository;
import com.example.springbackend.services.StakeholderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class StakeholderController {

    @Autowired
    private StakeholderService stakeholderService;

//    @GetMapping("/stakeholders")
//    public ResponseEntity<List<StakeholderDao>> getAllStakeholder() {
//        return ResponseEntity.ok(this.stakeholderService.getAllStakeholder());
//    }
//
//    @GetMapping("/stakeholders/{stakeholder_id}")
//    public Stakeholder getStakeholderById(@PathVariable Long stakeholder_id) {
//        return stakeholderRepository.findById(stakeholder_id).get();
//    }
//
//    @PostMapping("/stakeholders")
//    public Stakeholder saveStakeholderDetails(@RequestBody Stakeholder stakeholder) {
//        return stakeholderRepository.save(stakeholder);
//    }
//
//    @PutMapping("/stakeholders")
//    public Stakeholder updateStakeholder(@RequestBody Stakeholder stakeholder) {
//        return stakeholderRepository.save(stakeholder);
//    }
//
//    @DeleteMapping("/stakeholders/{stakeholder_id}")
//    public ResponseEntity<HttpStatus> deleteStakeholderById(@PathVariable Long stakeholder_id) {
//        stakeholderRepository.deleteById(stakeholder_id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    // new
    @GetMapping("/stakeholders")
    public ResponseEntity<List<StakeholderDao>> getAllStakeholder() {
        return ResponseEntity.ok(this.stakeholderService.getAllStakeholder());
    }


    @GetMapping("/stakeholders/{stakeholder_id}")
    public  ResponseEntity<StakeholderDao> getStakeholderById(@PathVariable Long stakeholder_id){
        return ResponseEntity.ok(this.stakeholderService.getStakeholderById(stakeholder_id));

    }

    @PostMapping("/stakeholders")
    public ResponseEntity<StakeholderDao> createStakeholderDetails(@Valid @RequestBody StakeholderDao stakeholderDao) {
        StakeholderDao createStakeholerDao = this.stakeholderService.createStakeholderDetails(stakeholderDao);
        return new ResponseEntity<>(createStakeholerDao, HttpStatus.CREATED);

    }

    @PutMapping("/stakeholders/{stakeholder_id}")
    public ResponseEntity<StakeholderDao> updateStakeholder(@Valid @RequestBody StakeholderDao stakeholderDao, @PathVariable Long stakeholder_id) {
        StakeholderDao updateStakeholder = this.stakeholderService.updateStakeholder(stakeholderDao, stakeholder_id);
        return ResponseEntity.ok(updateStakeholder);
    }


    @DeleteMapping("/stakeholders/{stakeholder_id}")
    public ResponseEntity<ApiResponse> deleteStakeholderById(@PathVariable Long stakeholder_id){
        this.stakeholderService.deleteStakeholderById(stakeholder_id);
        return new ResponseEntity(new ApiResponse("Stakeholder deleted successfully", true), HttpStatus.OK);
    }
}
