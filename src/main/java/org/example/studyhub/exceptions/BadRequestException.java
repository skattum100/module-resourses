package org.example.studyhub.exceptions;

// Exception thrown for invalid or malformed data, maps to a 400 Bad Request HTTP status
    public class BadRequestException extends RuntimeException {

        public BadRequestException(String message) {
            super(message);
        }
    }

