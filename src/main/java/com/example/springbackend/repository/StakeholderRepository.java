package com.example.springbackend.repository;

import com.example.springbackend.model.Stakeholder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StakeholderRepository extends JpaRepository<Stakeholder,Long> {
}
