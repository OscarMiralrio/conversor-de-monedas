package com.alura.challenge.conversor.utilerias;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EventLogger {

    private static final Logger logger = Logger.getLogger(EventLogger.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("event_log.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error occurred in setting up logger", e);
        }
    }

    public static void logEvent(String message) {
        logger.info(message);
    }
}
