package com.sachet.departmentservice.service.impl;

import com.sachet.departmentservice.dto.DepartmentDto;
import com.sachet.departmentservice.entity.Department;
import com.sachet.departmentservice.repository.DepartmentRepository;
import com.sachet.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //Convert DepartmentDto to Department JPA Entity
        Department department = modelMapper.map(departmentDto, Department.class);
        return modelMapper.map(departmentRepository.save(department), DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code).orElseThrow();
        return modelMapper.map(department, DepartmentDto.class);
    }


}
