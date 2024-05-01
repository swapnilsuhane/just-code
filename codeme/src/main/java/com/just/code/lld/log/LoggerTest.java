package com.just.code.lld.log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerTest {
    private static org.slf4j.Logger logger2;

    public static void main(String[] args) {
        Logger logger = new LoggerImpl(LogLevel.INFO, "TEST_LOG");
        logger.warn("Hello Warn");
        logger.info("Hello Info");
        logger.error("Hello Error");

        log.info("fsadf");
        logger2.info("fdsa");

    }
}
