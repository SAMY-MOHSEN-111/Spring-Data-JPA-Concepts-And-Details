package com.global.hr.controller;

import com.global.hr.entity.Department;
import com.global.hr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    @Autowired //constructor injection
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> findAll(){
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id){
        return departmentService.findById(id);
    }

    @PostMapping
    public Department insert(@RequestBody Department department){
        return departmentService.save(department);
    }

    @PutMapping
    public Department update(@RequestBody Department department){
        return departmentService.update(department);
    }
}
