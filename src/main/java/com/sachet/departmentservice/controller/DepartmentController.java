package com.sachet.departmentservice.controller;

import com.sachet.departmentservice.dto.DepartmentDto;
import com.sachet.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> create(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.saveDepartment(departmentDto));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<DepartmentDto> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(departmentService.getDepartmentByCode(code));
    }

}
