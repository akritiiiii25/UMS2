//package com.ums.repository;
//
//import com.ums.entity.Employee;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//@Repository
//public interface IEmployee extends JpaRepository<Employee, String>
//{
//
//    @Query(value = "SELECT e FROM Employee e WHERE e.salary = :salary")
//    List<Employee> findEmployeesHavingSalary(@Param("salary") double salary);
//   // boolean existsByEmployeeName(String employeeName);
//   boolean existsByEmployeeNameAndPhoneNumberAndSalary(String employeeName, String phoneNumber, double salary);
//
//}
//


package com.ums.repository;

import com.ums.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IEmployee extends JpaRepository<Employee, String> {
    List<Employee> findBySalary(double salary);
    boolean existsByEmployeeNameAndPhoneNumberAndSalary(String employeeName, String phoneNumber, double salary);
}
