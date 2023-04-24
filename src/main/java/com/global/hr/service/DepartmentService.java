package com.global.hr.service;

import com.global.hr.entity.Department;
import com.global.hr.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    @Autowired
    public void wireDepartmentRepository(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public Department findById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
        // save will check if the id is present(not null) if so it will update else insert
    }

//    public List<Department> save(List<Department> departments) {
//        return departmentRepository.saveAll(departments);
//        // save will check if the id is present(not null) if so it will update else insert
//    }

    public Department update(Department department) {
        Optional<Department> optionalDepartment = departmentRepository.findById(department.getId());
        if(optionalDepartment.isEmpty())throw new RuntimeException("Department not found");

        Department dbDepartment = optionalDepartment.get();
        dbDepartment.setName(department.getName());
        return departmentRepository.save(dbDepartment);
        // save will check if the id is present(not null) if so it will update else insert
        // but retrieving that object from db then updating the desired fields only is preferable
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
