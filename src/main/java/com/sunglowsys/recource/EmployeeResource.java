package com.sunglowsys.recource;

import com.sunglowsys.domain.Employee;
import com.sunglowsys.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee result = employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee result = employeeService.update(employee);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findOne(@PathVariable Long id){
        Employee result = employeeService.findOne(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @GetMapping("/employees")
    public ResponseEntity<Page<Employee>> findAll(Pageable pageable){
       Page<Employee> employees = employeeService.findAll(pageable);
       return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
