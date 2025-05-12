package org.example.studyhub.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    // Exception thrown when resource is not found in the system, maps to a 404 Not Found HTTP status
    public ResourceNotFoundException (String message) {
            super(message);
        }
    }

