package com.global.hr.service;

import com.global.hr.entity.Account;
import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private DepartmentService departmentService;
    private AccountService accountService;
    private RoleService roleService;

    @Autowired
    public void wireEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    public void wireDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Autowired
    public void wireAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void wireRoleService(RoleService roleService) {
        this.roleService = roleService;
    }


    public List<Employee> findBySalary(Double salary) {
        return employeeRepository.findBySalary(salary);
    }

    public Employee findById(long id) {
        // could be handled better than that XD
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findByEmpAndDept(String empName, String deptName) {
        return employeeRepository.findByNameContainingAndDepartmentNameContaining(empName, deptName);
    }

    public Long countByEmpAndDept(String empName, String deptName) {
        return employeeRepository.countByNameContainingAndDepartmentNameContaining(empName, deptName);
    }

    public Long deleteByEmpAndDept(String empName, String deptName) {
        return employeeRepository.deleteByNameContainingAndDepartmentNameContaining(empName, deptName);
    }

    public List<Employee> filter(String name, Double salary) {
        return employeeRepository.filter(name, salary);
//        return employeeRepository.filterNative(name);
    }

    public Employee save(Employee employee) {
        // assign employee to an existing department
        if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            employee.setDepartment(departmentService.findById(employee.getDepartment().getId()));
        }

        // assign employee to an existing account
        if (employee.getAccount() != null && employee.getAccount().getId() != null) {
            Account dbAccount = accountService.findById(employee.getAccount().getId());
            dbAccount.setRoles(employee.getAccount().getRoles());
            employee.setAccount(dbAccount);
        }


        return employeeRepository.save(employee);
        // save will check if the id is present(not null) if so it will update else insert
    }

//    public List<Employee>save(List<Employee> employees) {
//        return employeeRepository.saveAll(employees);
//        // save will check if the id is present(not null) if so it will update else insert
//    }

    public Employee update(Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
        if (optionalEmployee.isEmpty()) throw new RuntimeException("Employee not found");

        Employee dbEmployee = optionalEmployee.get();

        dbEmployee.setName(employee.getName());
        dbEmployee.setSalary(employee.getSalary());
        dbEmployee.setDepartment(employee.getDepartment());

        Account dbAccount = dbEmployee.getAccount();

        dbAccount.setRoles(employee.getAccount().getRoles());// this is not working for some reason
        dbEmployee.setAccount(dbAccount);

        return employeeRepository.save(dbEmployee);
        // save will check if the id is present(not null) if so it will update else insert
        // but retrieving that object from db then updating the desired fields only is preferable
    }

    public List<Employee> findByDepartmentId(Long id) {
//        return employeeRepository.findByDepartmentId(id);
        return employeeRepository.findByDepartmentId(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
