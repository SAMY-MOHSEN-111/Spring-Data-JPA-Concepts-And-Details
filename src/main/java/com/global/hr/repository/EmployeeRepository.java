package com.global.hr.repository;

import com.global.hr.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Long id);

    List<Employee> findBySalary(Double salary);

    List<Employee> findByName(String name);

    List<Employee> findByNameContainingAndDepartmentNameContaining(String empName, String deptName);

    Long countByNameContainingAndDepartmentNameContaining(String empName, String deptName);

    @Modifying
    @Transactional
    Long deleteByNameContainingAndDepartmentNameContaining(String empName, String deptName);

    //JPQL: Java Persistence Query Language
    //Independent of Database
    @Query(value = "select employee from Employee employee where employee.name like concat('%',:name,'%') and employee.salary >= :salary ")
    List<Employee> filter(String name, Double salary);

    //Native SQL query
    //Database dependent
    @Query(value = "select * from `hr-global`.employee where employee.name like concat('%',:name,'%')", nativeQuery = true)
    List<Employee> filterNative(String name);

//    List<Employee> findByDepartmentId(Long id);
    // note that we sent it the dept ID and wrote it like that findBy`DepartmentId`

    @Query(value = "select employee from Employee employee inner join employee.department department where department.id = :id")
    List<Employee> findByDepartment(@Param("id") Long id);
}
/*
select
        (select count(*) from employee as employee_count),
        (select count(*) from department as department_count),
        (select count(*) from account as account_count),
        (select count(*) from role as role_count)
*/
