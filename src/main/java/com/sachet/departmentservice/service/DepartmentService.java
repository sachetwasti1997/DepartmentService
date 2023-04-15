package com.sachet.departmentservice.service;

import com.sachet.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String code);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto updateDepartmentByCode(String code, DepartmentDto departmentDto);
    void deleteByCode(String code);
}
