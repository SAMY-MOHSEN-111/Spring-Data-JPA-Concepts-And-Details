package com.global.hr.controller;

import com.global.hr.entity.Employee;
import com.global.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    Employee findById(@PathVariable("id") long id) {
        return employeeService.findById(id);
    }

    @GetMapping("/filter")
    public List<Employee> filter(@RequestParam("name") String name) {
        return employeeService.filter(name);
    }

    @GetMapping("/department/{id}")
    public List<Employee> findByDepartmentId(@PathVariable("id")Long id){
        return employeeService.findByDepartmentId(id);
    }

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @PostMapping
    public Employee insert(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }
}
