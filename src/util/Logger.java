package org.nacha.paymentsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logger {
    private static final Logger logger = LoggerFactory.getLogger(Logger.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    public static void audit(String action, String user) {
        logger.info("[AUDIT] Action: {}, User: {}", action, user);
    }
}