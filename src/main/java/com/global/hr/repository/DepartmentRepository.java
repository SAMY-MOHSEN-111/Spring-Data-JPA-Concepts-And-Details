package com.global.hr.repository;

import com.global.hr.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query(value = "delete from Department department where department.name = :deptName")
    int deleteByName(@Param("deptName") String deptName);

    @Transactional(readOnly = false,rollbackFor = {RuntimeException.class}) /*default is not to read only*/
    @Query(value = "update Department department set department.name = :deptName where department.name = :deptName")
    int updateByName(@Param("deptName") String deptName);
}
