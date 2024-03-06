package com.ums.controller;

import com.ums.dto.OfficeDto;
import com.ums.entity.Office;
import com.ums.service.OfficeService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/office")
@RestController
@Validated
public class OfficeController {
    private static final Logger log = LogManager.getLogger(OfficeController.class);

    @Autowired
    private OfficeService officeService;

    @PostMapping("/create")
    public Office createOffice(@Valid @RequestBody OfficeDto officeDto) {
        log.info("Office creation API is called!");
        return officeService.createOffice(officeDto);
    }


}

