package com.example.demo.Exception;

public class ExceptionTesting extends RuntimeException {

    public void functionForException() {
        throw new ExceptionTesting();
    }
}
