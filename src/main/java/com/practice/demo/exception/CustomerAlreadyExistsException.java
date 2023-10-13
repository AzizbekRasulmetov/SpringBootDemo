package com.practice.demo.exception;

public class CustomerAlreadyExistsException extends RuntimeException {

    public CustomerAlreadyExistsException() {
        super("Customer already exists");
    }

}
