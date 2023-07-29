package org.example;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AppLauncher {
    private static final Logger logger = LoggerFactory.getLogger(AppLauncher.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Application started.");



    }
}