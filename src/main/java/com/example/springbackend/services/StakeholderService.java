package com.example.springbackend.services;

import com.example.springbackend.playloads.ComplaintDetailsDao;
import com.example.springbackend.playloads.StakeholderDao;

import java.util.List;

public interface StakeholderService {

    StakeholderDao updateStakeholder(StakeholderDao stakeholder,Long stakeholder_id);
    StakeholderDao  getStakeholderById(Long stakeholder_id);
    List<StakeholderDao> getAllStakeholder();
    void deleteStakeholderById(Long stakeholder_id);

    StakeholderDao createStakeholderDetails(StakeholderDao stakeholderDao);
}
