package com.ums.controller;

import com.ums.dto.OfficeBranchDto;
import com.ums.service.OfficeBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/officeBranches")
public class OfficeBranchController
{
    private final OfficeBranchService officeBranchService;
    @Autowired
    public OfficeBranchController(OfficeBranchService officeBranchService)
    {
        this.officeBranchService = officeBranchService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> createOfficeBranch(@RequestBody OfficeBranchDto officeBranch)
    {
        ResponseEntity<?> response = officeBranchService.createOfficeBranch(officeBranch);
        return response;
    }
}

