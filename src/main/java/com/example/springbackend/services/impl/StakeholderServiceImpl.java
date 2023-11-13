package com.example.springbackend.services.impl;


import com.example.springbackend.exception.ResourceNotFoundException;
import com.example.springbackend.model.Admin;
import com.example.springbackend.model.Stakeholder;
import com.example.springbackend.playloads.AdminDao;
import com.example.springbackend.playloads.StakeholderDao;
import com.example.springbackend.repository.AdminRepository;
import com.example.springbackend.repository.StakeholderRepository;
import com.example.springbackend.services.StakeholderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StakeholderServiceImpl implements StakeholderService {
    @Autowired
    private StakeholderRepository stakeholderRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public StakeholderDao createStakeholderDetails(StakeholderDao stakeholderDao) {
        Stakeholder stakeholder =this.daoToStakeholder(stakeholderDao);
        Stakeholder savedStakeholder = this.stakeholderRepository.save(stakeholder);
        return this.stakeholderToDao(savedStakeholder);
    }

    @Override
    public StakeholderDao updateStakeholder(StakeholderDao stakeholderDao, Long stakeholder_id) {
        Stakeholder stakeholder = this.stakeholderRepository.findById(stakeholder_id).orElseThrow(()-> new ResourceNotFoundException("Stakeholder","id",stakeholder_id));
        stakeholder.setFirst_name(stakeholderDao.getFirst_name());
        stakeholder.setMiddle_name(stakeholderDao.getMiddle_name());
        stakeholder.setLast_name(stakeholderDao.getLast_name());
        stakeholder.setContact((int) stakeholderDao.getContact());
        stakeholder.setEmail(stakeholderDao.getEmail());
        stakeholder.setPassword(stakeholderDao.getPassword());
        stakeholder.setAccount_status(stakeholderDao.getAccount_status());
        stakeholder.setStakeholder_type(stakeholderDao.getStakeholder_type());
        stakeholder.setUser_name(stakeholderDao.getUser_name());

        Stakeholder updateStakeholder = this.stakeholderRepository.save(stakeholder);
        StakeholderDao stakeholderDao1 = this.stakeholderToDao(updateStakeholder);
        return stakeholderDao1;
    }


    @Override
    public StakeholderDao getStakeholderById(Long stakeholder_id) {
        Stakeholder stakeholder = this.stakeholderRepository.findById(stakeholder_id).orElseThrow(()->new ResourceNotFoundException("Stakeholder","id",stakeholder_id));

        return this.stakeholderToDao(stakeholder);
    }

    @Override
    public List<StakeholderDao> getAllStakeholder() {
        List<Stakeholder> stakeholders = this.stakeholderRepository.findAll();
        List<StakeholderDao> stakeholderDaos = stakeholders.stream().map(stakeholder -> this.stakeholderToDao(stakeholder)).collect(Collectors.toList());
        return stakeholderDaos;
    }

    @Override
    public void deleteStakeholderById(Long stakeholder_id) {
        Stakeholder stakeholder= this.stakeholderRepository.findById(stakeholder_id).orElseThrow(()-> new ResourceNotFoundException("Stakeholder","id",stakeholder_id));
        this.stakeholderRepository.delete(stakeholder);
    }

    public Stakeholder daoToStakeholder(StakeholderDao stakeholderDao){
        Stakeholder stakeholder = this.modelMapper.map(stakeholderDao, Stakeholder.class);
        return stakeholder;
    }

    public StakeholderDao stakeholderToDao(Stakeholder stakeholder){
        StakeholderDao stakeholderDao = this.modelMapper.map(stakeholder, StakeholderDao.class);
        return stakeholderDao;
    }
}
