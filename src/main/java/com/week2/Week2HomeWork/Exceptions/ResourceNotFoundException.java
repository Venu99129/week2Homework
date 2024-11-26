package com.week2.Week2HomeWork.Exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
