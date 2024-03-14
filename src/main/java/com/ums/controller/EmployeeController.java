//package com.ums.controller;
//
//import com.ums.dto.EmployeeDto;
//import com.ums.entity.Employee;
//import com.ums.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.http.ResponseEntity;
//@RestController
//@RequestMapping("/employees")
//public class EmployeeController
//{
//    private EmployeeService employeeService;
//    @Autowired
//    public EmployeeController(EmployeeService employeeService)
//    {
//        this.employeeService = employeeService;
//    }
//    @GetMapping("/count")
//    public ResponseEntity<Long> getCountOfEmployeesBySalary(@RequestParam double salary)
//    {
//        long count = employeeService.getCountOfEmployeesBySalary(salary);
//        return new ResponseEntity<>(count, HttpStatus.OK);
//    }
//    @PostMapping("/create")
//    public ResponseEntity<Employee> createEmployee (@RequestBody EmployeeDto employee)
//    {
//        Employee createdEmployee = employeeService.createEmployee(employee);
//        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
//    }
//
//
//}
package com.ums.controller;

import com.ums.dto.EmployeeDto;
import com.ums.entity.Employee;
import com.ums.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCountOfEmployeesBySalary(@RequestParam double salary) {
        long count = employeeService.getCountOfEmployeesBySalary(salary);
        return ResponseEntity.ok(count);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employeeDto) {
        ResponseEntity<?> response = employeeService.createEmployee(employeeDto);
        return response;
    }
}
