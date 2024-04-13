package com.ledger.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains static methods used for utility.
 * Example: loggers, calculations.
 * <p/>
 * This class cannot be instantiated.
 */
public class Utility {

    /**
     * This is a utility class. This shouldn't be instantiated. Hence, making it a private constructor.
     */
    private Utility() {}
    static Logger logger = Logger.getLogger(Utility.class.getName());

    /**
     * Logs errors with SEVERE level.
     * @param message message to be printed
     * @param e caught exception
     */
    public static void logError(String message, Exception e) {
        logger.log(Level.SEVERE, message, e);
    }

    /**
     * Logs info with INFO level.
     * @param message message to be printed
     */
    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }
}
