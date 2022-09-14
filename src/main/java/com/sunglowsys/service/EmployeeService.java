package com.sunglowsys.service;

import com.sunglowsys.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee update(Employee employee);

    Optional<Employee> findOne(Long id);

    Page<Employee> findAll(Pageable pageable);

    void delete(Long id);

}
