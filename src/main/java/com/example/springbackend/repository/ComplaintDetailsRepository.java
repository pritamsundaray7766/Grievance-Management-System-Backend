package com.example.springbackend.repository;

import com.example.springbackend.model.ComplaintDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintDetailsRepository extends JpaRepository<ComplaintDetails,Long> {
}
