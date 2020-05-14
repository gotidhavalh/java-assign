package com.assignment.javaassign.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assignment.javaassign.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
