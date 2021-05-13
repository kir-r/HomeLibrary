package com.epam.homelibrary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Home library
 */
public class Main {
    static final Logger logger = LogManager.getLogger(Main.class);
    static BufferedReader reader;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            logger.info("Welcome to Home Library!\nPlease login\nLogin: ");
            String login = reader.readLine();
            logger.info("Password: ");
            String password = reader.readLine();

            Controller controller = new Controller();
            controller.operate(login, password);

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        cleanUp();
    }

    private static void cleanUp() {
        try {
            reader.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
