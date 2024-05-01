package com.just.code.lld.scheduler.exception;

public class ScheduleLimitExceedException extends RuntimeException{
    public ScheduleLimitExceedException(String message) {
        super(message);
    }
}
