package com.sachet.departmentservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private Long id;
    @NotEmpty(message = "Department Name should not be null or empty!")
    private String departmentName;
    @NotEmpty(message = "Department Description should not be null or empty!")
    private String departmentDescription;
    @NotEmpty(message = "Department CODE should not be null or empty!")
    private String departmentCode;
}
