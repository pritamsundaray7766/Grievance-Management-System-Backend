package com.example.springbackend.repository;

import com.example.springbackend.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
}
