package com.just.code.lld.log;

public class LoggerImpl implements Logger {
    private final LogLevel logLevel;
    private final String logName;

    public LoggerImpl(LogLevel logLevel, String logName) {
        this.logLevel = logLevel;
        this.logName = logName;
    }

    @Override
    public void info(String msg) {
        if (logLevel.isInfoLevel()) {
            System.out.println(logName + ": " + msg);
        }
    }

    @Override
    public void warn(String msg) {
        if (logLevel.isWarnLevel()) {
            System.out.println(logName + ": " + msg);
        }
    }

    @Override
    public void error(String msg) {
        if (logLevel.isErrorLevel()) {
            System.out.println(logName + ": " + msg);
        }
    }

    @Override
    public void error(String msg, Throwable throwable) {
        if (logLevel.isErrorLevel()) {
            System.out.println(logName + ": " + msg + " , Error: " + throwable);
        }
    }
}
