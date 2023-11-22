package com.example.springbackend.services.impl;

import com.example.springbackend.exception.ResourceNotFoundException;
import com.example.springbackend.model.Admin;
import com.example.springbackend.model.User;
import com.example.springbackend.playloads.AdminDao;
import com.example.springbackend.playloads.UserDto;
import com.example.springbackend.repository.AdminRepository;
import com.example.springbackend.services.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public AdminDao createAdmin(AdminDao adminDao) {
        Admin admin=this.daoToAdmin(adminDao);
        Admin savedAdmin = this.adminRepository.save(admin);
        return this.adminToDao(savedAdmin);

    }

    @Override
    public AdminDao updateAdmin(AdminDao adminDao, Long admin_id) {
        Admin admin = this.adminRepository.findById(admin_id).orElseThrow(()-> new ResourceNotFoundException("Admin","id",admin_id));
        admin.setFirst_name(adminDao.getFirst_name());
        admin.setMiddle_name(adminDao.getMiddle_name());
        admin.setLast_name(adminDao.getLast_name());
        admin.setRole(adminDao.getRole());
        admin.setContact((int) adminDao.getContact());
        admin.setEmail(adminDao.getEmail());
        admin.setPassword(adminDao.getPassword());
        admin.setAccount_status(adminDao.getAccount_status());

        Admin updateAdmin = this.adminRepository.save(admin);
        AdminDao adminDao1 = this.adminToDao(updateAdmin);
        return adminDao1;
    }

    @Override
    public AdminDao getAdminById(Long admin_id) {
        Admin admin = this.adminRepository.findById(admin_id).orElseThrow(()->new ResourceNotFoundException("Admin", "id", admin_id));

        return this.adminToDao(admin);
    }

    @Override
    public List<AdminDao> getAllAdmin() {
        List<Admin> admins = this.adminRepository.findAll();
        List<AdminDao> adminDaos = admins.stream().map(admin -> this.adminToDao(admin)).collect(Collectors.toList());
        return adminDaos;
    }

    @Override
    public void deleteAdmin(Long admin_id) {
        Admin admin= this.adminRepository.findById(admin_id).orElseThrow(()-> new ResourceNotFoundException("Admin", "id", admin_id));
        this.adminRepository.delete(admin);
    }

    public Admin daoToAdmin(AdminDao adminDao){
        Admin admin = this.modelMapper.map(adminDao, Admin.class);
        return admin;
    }

    public AdminDao adminToDao(Admin admin){
        AdminDao adminDao = this.modelMapper.map(admin, AdminDao.class);
        return adminDao;
    }
}
