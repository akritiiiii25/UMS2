package com.ums.service;

import com.ums.dto.OfficeBranchDto;
import com.ums.entity.OfficeBranch;
import com.ums.repository.IOfficeBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeBranchService {

    @Autowired
    private IOfficeBranch officeBranchRepository;

    public OfficeBranch createOfficeBranch(OfficeBranchDto officeBranchDto) {
        OfficeBranch officeBranch = new OfficeBranch();
        officeBranch.setBranchName(officeBranchDto.getBranchName());
        officeBranch.setBranchCode(officeBranchDto.getBranchCode());
        // Set other properties if needed
        return officeBranchRepository.save(officeBranch);
    }


}

