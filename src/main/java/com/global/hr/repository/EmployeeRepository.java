package com.global.hr.repository;

import com.global.hr.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    //JPQL: Java Persistence Query Language
    //Independent of Database
    @Query(value = "select employee from Employee employee where employee.name like concat('%',:name,'%') ")
    List<Employee> filter(String name);

    //Native SQL query
    //Database dependent
    @Query(value = "select * from `hr-global`.employee where employee.name like concat('%',:name,'%')", nativeQuery = true)
    List<Employee> filterNative(String name);

    List<Employee> findByDepartmentId(Long id);
    // note that we sent it the dept ID and wrote it like that findBy`DepartmentId`

    @Query(value = "select employee from Employee employee inner join employee.department department where department.id = :id")
    List<Employee> findByDepartment(@Param("id") Long id);
}
