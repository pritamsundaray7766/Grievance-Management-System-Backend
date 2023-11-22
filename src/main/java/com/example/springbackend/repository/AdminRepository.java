package com.example.springbackend.repository;

import com.example.springbackend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {


    //all CRUD database methods

}
