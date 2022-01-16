package com.techelevator;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger {
    public static void log(String message) {
        FileHandler handler = null;

        try {
            // Get file to log out to.
            handler = new FileHandler("C:\\Users\\Student\\workspace\\mod1-capstone-blue-team7\\java\\log.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create logger.
        Logger logger = Logger.getLogger("VendingMachineLogger");

        // Make sure log messages are simple.
        SimpleFormatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);

        // Configure logger to use our log.txt file.
        logger.addHandler(handler);

        // Don't log out to console, only to file.
        logger.setUseParentHandlers(false);

        // Log our message.
        logger.info(message);
    }
}
