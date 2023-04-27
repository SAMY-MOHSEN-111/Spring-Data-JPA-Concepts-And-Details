package com.global.hr.repository;

import com.global.hr.entity.Dual;
import com.global.hr.projection.HRStatisticsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DualRepository extends JpaRepository<Dual,Long> {
    @Query(value = "select " +
            "(select count(*) from `hr-global`.employee) as empCount," +
            "(select count(*) from `hr-global`.department) as deptCount," +
            "(select count(*) from `hr-global`.account) as accountCount," +
            "(select count(*) from `hr-global`.role) as roleCount"
            , nativeQuery = true)
    HRStatisticsProjection getHRStatisticsNative();

    @Query(value = "Select " +
            "(select count(employee) from Employee employee) as empCount, " +
            "(select count(department) from Department department) as deptCount," +
            "(select count(account) from Account account) as accountCount," +
            "(select count(role) from Role role) as roleCount")
    HRStatisticsProjection getHrStatisticsJPQL();
}
