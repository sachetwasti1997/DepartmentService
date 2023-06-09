package com.sachet.departmentservice.controller;

import com.sachet.departmentservice.dto.DepartmentDto;
import com.sachet.departmentservice.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> create(@RequestBody @Valid DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.saveDepartment(departmentDto));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<DepartmentDto> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(departmentService.getDepartmentByCode(code));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PutMapping("/update/{code}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable String code,
            @RequestBody @Valid DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.updateDepartmentByCode(code, departmentDto));
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteDepartment(@PathVariable String code) {
        departmentService.deleteByCode(code);
        return ResponseEntity.ok("Department with code: "+code+" deleted successfully!");
    }

}
