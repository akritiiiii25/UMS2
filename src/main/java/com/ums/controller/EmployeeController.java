package com.ums.controller;
import com.ums.entity.Employee;

import com.ums.dto.EmployeeDto;
import com.ums.service.EmployeeService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employee")
@RestController
@Validated
public class EmployeeController {
    private static final Logger log = LogManager.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        log.info("Employee creation API is called!");
        return employeeService.createEmployee(employeeDto);
    }

    @GetMapping("/count")
    public int getCountOfEmployeesWithSalary(@RequestParam Double salary) {
        log.info("Fetching count of employees with salary: " + salary);
        return employeeService.getCountBySalary(salary);
    }
}
