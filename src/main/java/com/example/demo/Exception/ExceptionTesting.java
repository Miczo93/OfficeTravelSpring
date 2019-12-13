package com.example.demo.Exception;

public class ExceptionTesting extends RuntimeException {

    public void  FunctionForException() {
        throw new ExceptionTesting();
    }
}
