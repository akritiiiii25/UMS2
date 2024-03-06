package com.ums.controller;

import com.ums.dto.OfficeBranchDto;
import com.ums.entity.OfficeBranch;
import com.ums.service.OfficeBranchService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/office-branch")
@RestController
@Validated
public class OfficeBranchController {
    private static final Logger log = LogManager.getLogger(OfficeBranchController.class);

    @Autowired
    private OfficeBranchService officeBranchService;
    @PostMapping("/create")
    public OfficeBranch createOfficeBranch(@Valid @RequestBody OfficeBranchDto officeBranchDto) {
        log.info("Office Branch creation API is called!");
        return officeBranchService.createOfficeBranch(officeBranchDto);
    }


}

