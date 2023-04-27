package com.global.hr.controller;

import com.global.hr.dto.EmployeeDTO;
import com.global.hr.entity.Employee;
import com.global.hr.entity.EmployeeResponse;
import com.global.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public void wireEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/salary")
    public ResponseEntity<?> findBySalary(
            @RequestParam("salary") Double salary
    ) {
        return ResponseEntity.ok(employeeService.findBySalary(salary));
    }

    @GetMapping("/{id}")
    public EmployeeResponse findById(@PathVariable("id") long id) {
        // I think this logic should be but in service layer
        Employee employee = employeeService.findById(id);
        System.out.println(employee);//delete

        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setDepartment(employee.getDepartment());
        employeeResponse.setAccount(employee.getAccount());
        return employeeResponse;
    }

    @GetMapping(path = "/emp-dept")
    List<Employee> findByEmpAndDept(
            @RequestParam("empName") String empName,
            @RequestParam("deptName") String deptName
    ) {
        return employeeService.findByEmpAndDept(empName, deptName);
    }


    @GetMapping(path = "/count-emp-dept")
    ResponseEntity<?> countByEmpAndDept(
            @RequestParam("empName") String empName,
            @RequestParam("deptName") String deptName
    ) {
        return ResponseEntity.ok(employeeService.countByEmpAndDept(empName, deptName));
    }

    @DeleteMapping(path = "/emp-dept")
    ResponseEntity<?> deleteByEmpAndDept(
            @RequestParam("empName") String empName,
            @RequestParam("deptName") String deptName
    ) {
        return ResponseEntity.ok(employeeService.deleteByEmpAndDept(empName, deptName));
    }

    // @GetMapping("/{id}")
    // Employee findById(@PathVariable("id") long id) {
    //     return employeeService.findById(id);
    // }

    @GetMapping("/filter")
    public List<Employee> filter(
            @RequestParam("name") String name,
            @RequestParam("salary") Double salary
    ) {
        return employeeService.filter(name, salary);
    }

    @GetMapping("/department/{id}")
    public List<EmployeeDTO> findByDepartmentId(@PathVariable("id") Long id) {
        return employeeService.findByDepartmentId(id);
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping
    public Employee insert(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

}
