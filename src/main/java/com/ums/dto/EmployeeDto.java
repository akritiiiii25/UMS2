package com.ums.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto
{
    private String employeeName;
    private String phoneNumber;
    private Double salary;
}

