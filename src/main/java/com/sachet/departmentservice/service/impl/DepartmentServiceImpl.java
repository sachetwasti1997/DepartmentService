package com.sachet.departmentservice.service.impl;

import com.sachet.departmentservice.dto.DepartmentDto;
import com.sachet.departmentservice.entity.Department;
import com.sachet.departmentservice.exception.CodeAlreadyExist;
import com.sachet.departmentservice.exception.ResourceNotFound;
import com.sachet.departmentservice.repository.DepartmentRepository;
import com.sachet.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Optional<Department> departmentOp = departmentRepository.findByDepartmentCode(departmentDto.getDepartmentCode());
        if (departmentOp.isPresent()) {
            throw new CodeAlreadyExist("Code "+departmentDto.getDepartmentCode()+" already exist, please enter a unique " +
                    "code");
        }
        //Convert DepartmentDto to Department JPA Entity
        Department department = modelMapper.map(departmentDto, Department.class);
        return modelMapper.map(departmentRepository.save(department), DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository
                .findByDepartmentCode(code)
                .orElseThrow(() -> new ResourceNotFound("Department", "CODE", code));
        return modelMapper.map(department, DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(department -> modelMapper.map(department, DepartmentDto.class)).toList();
    }
    @Override
    public DepartmentDto updateDepartmentByCode(String code, DepartmentDto departmentDto) {
        Department department = departmentRepository
                .findByDepartmentCode(code)
                .orElseThrow(() -> new ResourceNotFound("Department",
                        "CODE",
                        code));
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        return modelMapper.map(departmentRepository.save(department), DepartmentDto.class);
    }

    @Override
    public void deleteByCode(String code) {
        Department department = departmentRepository
                .findByDepartmentCode(code)
                .orElseThrow(() -> new ResourceNotFound("Department", "CODE", code));
        departmentRepository.delete(department);
    }
}
