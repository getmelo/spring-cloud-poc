package com.getmelo.poc.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException {


        private final String key;
        private final List<String> args;

        public ResourceNotFoundException(String message) {
            super(message);
            this.key = null;
            this.args = null;
        }

        public ResourceNotFoundException(String message, String key) {
            super(message);
            this.key = key;
            this.args = null;
        }

        public ResourceNotFoundException(String message, String key, Throwable cause) {
            super(message, cause);
            this.key = key;
            this.args = null;
        }

        public ResourceNotFoundException(String message, String key, List<String> args) {
            super(message);
            this.key = key;
            this.args = args;
        }

        public ResourceNotFoundException(String message, String key, List<String> args, Throwable cause) {
            super(message, cause);
            this.key = key;
            this.args = args;
        }

        public String getKey() {
            return key;
        }

        public List<String> getArgs() {
            return args;
        }
    }
