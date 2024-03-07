////package com.ums.controller;
////
////
////import com.ums.entity.Office;
////import com.ums.service.OfficeService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.web.bind.annotation.*;
////import org.springframework.http.ResponseEntity;
////
////@RestController
////@RequestMapping("/offices")
////public class OfficeController {
////    private OfficeService officeService;
////    @Autowired
////    public OfficeController(OfficeService officeService)
////    {
////        this.officeService = officeService;
////    }
////    @PostMapping("/create")
////    public ResponseEntity<Office> createOffice(@RequestBody Office office)
////    {
////        Office createdOffice = officeService.createOffice(office);
////        return new ResponseEntity<>(createdOffice, HttpStatus.CREATED);
////    }
////}
//package com.ums.controller;
//
//import com.ums.dto.OfficeDto;
//import com.ums.entity.Office;
//import com.ums.service.OfficeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/offices")
//public class OfficeController {
//
//    private final OfficeService officeService;
//
//    @Autowired
//    public OfficeController(OfficeService officeService) {
//        this.officeService = officeService;
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createOffice(@RequestBody OfficeDto officeDto) {
//        try {
//            Office createdOffice = officeService.createOffice(officeDto);
//            return new ResponseEntity<>(createdOffice, HttpStatus.CREATED);
//        } catch (CustomException e) {
//            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
//        }
//    }
//}
package com.ums.controller;

import com.ums.dto.OfficeDto;
import com.ums.entity.Office;
import com.ums.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOffice(@RequestBody OfficeDto officeDto) {
        try {
            Office createdOffice = officeService.createOffice(officeDto);
            return new ResponseEntity<>(createdOffice, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Office with provided details already exists");
        }
    }
}
