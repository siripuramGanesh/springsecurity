package com.ganeshsiripuram.springsecurity.springsecurity.exceptions;



public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
