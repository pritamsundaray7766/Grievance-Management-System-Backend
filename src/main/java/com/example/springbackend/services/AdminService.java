package com.example.springbackend.services;

import com.example.springbackend.playloads.AdminDao;
import com.example.springbackend.playloads.UserDto;

import java.util.List;

public interface AdminService {

    AdminDao createAdmin(AdminDao admin);
    AdminDao updateAdmin(AdminDao admin,Long admin_id);
    AdminDao  getAdminById(Long admin_id);
    List<AdminDao> getAllAdmin();
    void deleteAdmin(Long admin_id);
}
