package com.ums.service;

import com.ums.dto.EmployeeDto;
import com.ums.entity.Employee;
import com.ums.repository.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private IEmployee employeeRepository;

    public Employee createEmployee(EmployeeDto employeeDto)
    {

        Employee employee = new Employee();
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setSalary(employeeDto.getSalary());
        return employeeRepository.save(employee);
    }

    public int getCountBySalary(Double salary) {
        return employeeRepository.countBySalary(salary);
    }
}
