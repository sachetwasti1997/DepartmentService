package com.sachet.departmentservice.exception;

public class ResourceNotFound extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private String fieldValue;

    public ResourceNotFound(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
