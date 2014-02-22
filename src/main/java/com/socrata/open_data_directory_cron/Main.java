package com.socrata.open_data_directory_cron;

import org.apache.log4j.Logger;

/**
 * Author: Louis Fettet
 * Date: 2/22/14
 */
public class Main implements Runnable {

    // Initialize our log4j logger
    static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Thread job = new Thread(new Main());
        job.start();
        try {
            job.join();
        } catch (InterruptedException interruptedException) {
            logger.fatal("Interrupted Exception: " + interruptedException.getMessage());
        }
        try {
            // Sleep for twenty-four hours.
            Thread.sleep(86400000);
        } catch (InterruptedException interruptedException) {
            logger.fatal("Interrupted Exception: " + interruptedException.getMessage());
        }
    }

    @Override
    public void run() {

    }
}

