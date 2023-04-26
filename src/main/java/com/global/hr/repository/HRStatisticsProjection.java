package com.global.hr.repository;

public interface HRStatisticsProjection {
    Long getEmpCount();//same as the column name but prefixed with get following the naming convention
    Long getDeptCount();
    Long getAccountCount();
    Long getRoleCount();
}
