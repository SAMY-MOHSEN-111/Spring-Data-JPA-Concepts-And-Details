package com.global.hr.config;


import com.global.hr.entity.Account;
import com.global.hr.entity.Department;
import com.global.hr.entity.Employee;
import com.global.hr.entity.Role;
import com.global.hr.service.AccountService;
import com.global.hr.service.DepartmentService;
import com.global.hr.service.EmployeeService;
import com.global.hr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class Startup implements ApplicationRunner {
    private final AccountService accountService;
    private final RoleService roleService;
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @Autowired
    public Startup(
            AccountService accountService,
            RoleService roleService,
            DepartmentService departmentService,
            EmployeeService employeeService
    ) {
        this.accountService = accountService;
        this.roleService = roleService;
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //create roles
        Role admin = new Role();
        admin.setName("Admin");

        Role user = new Role();
        user.setName("User");

        roleService.save(List.of(admin, user));

        // create Accounts
//        Account adminAccount = new Account();
//        adminAccount.setUsername("admin");
//        adminAccount.setPassword("admin");
//        adminAccount.setRoles(Set.of(admin, user));
//
//        Account userAccount = new Account();
//        userAccount.setUsername("user");
//        userAccount.setPassword("user");
//        userAccount.setRoles(Set.of(user));
//
//        accountService.save(List.of(adminAccount, userAccount));

        // create departments
//        Department is = new Department();
//        is.setName("IS");
//
//        Department hr = new Department();
//        hr.setName("HR");
//
//        Department cs = new Department();
//        cs.setName("CS");
//
//        departmentService.save(List.of(is,hr,cs));
//
//
//        // create 2 employees
//        Employee samy = new Employee();
//        samy.setName("Samy Mohsen");
//        samy.setSalary(5000.0);
//        samy.setDepartment(is);
//        samy.setAccount(adminAccount);
//
//        Employee ahmed = new Employee();
//        ahmed.setName("Ahmed Hesham");
//        ahmed.setSalary(2500.5);
//        ahmed.setDepartment(hr);
//        ahmed.setAccount(userAccount);
//
//        employeeService.save(List.of(samy,ahmed));
    }
}
