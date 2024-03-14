package com.ums.service;

import com.ums.dto.EmployeeDto;
import com.ums.entity.Employee;
import com.ums.entity.OfficeBranch;
import com.ums.repository.IEmployee;
import com.ums.repository.IOfficeBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService
{
    private final IEmployee employeeRepository;
    private final IOfficeBranch officeBranchRepository;

    @Autowired
    public EmployeeService(IEmployee employeeRepository, IOfficeBranch officeBranchRepository)
    {
        this.employeeRepository = employeeRepository;
        this.officeBranchRepository = officeBranchRepository;
    }
    public long getCountOfEmployeesBySalary(double salary)
    {
        List<Employee> employees = employeeRepository.findBySalary(salary);
        return employees.size();
    }
    public ResponseEntity<?> createEmployee(EmployeeDto employeeDto)
    {
        boolean employeeExists = employeeRepository.existsByEmployeeNameAndPhoneNumberAndSalary(employeeDto.getEmployeeName(), employeeDto.getPhoneNumber(), employeeDto.getSalary());

        if (employeeExists)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee already exists with the provided details.");
        }

        Employee employee = new Employee();
        Optional<OfficeBranch> officeBranch = officeBranchRepository.findById(employeeDto.getOfficeBranchId());
        officeBranch.ifPresent(employee::setOfficeBranch);

        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setSalary(employeeDto.getSalary());

        Employee createdEmployee = employeeRepository.save(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }
}
