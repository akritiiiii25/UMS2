
package com.ums.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class EmployeeDto
{
    private String employeeName;
    private String phoneNumber;
    private double salary;
    private String officeBranchId;
    private List<String> employeeIds;
}
