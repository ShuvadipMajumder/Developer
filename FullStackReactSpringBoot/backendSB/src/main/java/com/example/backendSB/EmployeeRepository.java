package com.example.backendSB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // This interface will automatically provide CRUD operations for Employee
    // entities} {

}
