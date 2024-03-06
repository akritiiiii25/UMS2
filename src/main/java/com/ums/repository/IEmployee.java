package com.ums.repository;

import com.ums.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface IEmployee extends JpaRepository <Employee, String>
{
    @Query(value = "SELECT COUNT(*) FROM Employee WHERE salary = :salary", nativeQuery = true)
    int countBySalary(@Param("salary") Double salary);
}
