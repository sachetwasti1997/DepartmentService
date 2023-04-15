package com.sachet.departmentservice.exception;

public class CodeAlreadyExist extends RuntimeException{

    private String message;

    public CodeAlreadyExist(String message) {
        super(message);
        this.message = message;
    }
}
