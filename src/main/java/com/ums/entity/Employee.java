package com.ums.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name="Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee extends Base{

  @NotEmpty
  @Column(unique = true)
  private String employeeName;

  @NotNull
  private String phoneNumber;

  @NotNull
  private double salary;

  @ManyToOne
  @JoinColumn(name = "office_branch_id")
  private OfficeBranch officeBranch;
public class Employee extends Base 
{
    @NotEmpty(message = "Employee name:")
    @Column(unique = true)
    private String employeeName;
    @NotNull(message = "Employee Phone number:")
    private String phoneNumber;
    @NotNull(message = "Employee Salary:")
    private Double salary;
    @ManyToOne
    @JoinColumn(name = "office_branch_id")
    private OfficeBranch officeBranch;
    private Boolean isDelete = false;
}
