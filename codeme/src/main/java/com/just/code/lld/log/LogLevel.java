package com.just.code.lld.log;

public enum LogLevel {
    WARN, INFO, ERROR;

    public boolean isWarnLevel() {
        return this == WARN;
    }

    public boolean isInfoLevel() {
        return this == INFO || this == WARN;
    }

    public boolean isErrorLevel() {
        return this == INFO || this == WARN || this == ERROR;
    }
}
