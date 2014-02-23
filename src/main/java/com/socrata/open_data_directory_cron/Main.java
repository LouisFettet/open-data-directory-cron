package com.socrata.open_data_directory_cron;

import com.socrata.open_data_directory_cron.model.DataJsonEndpoint;
import com.socrata.open_data_directory_cron.model.DataJsonSingleEntry;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


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
        } catch (InterruptedException e) {
            logger.fatal("Interrupted Exception: " + e.getMessage());
        }
        try {
            // Sleep for twenty-four hours.
            Thread.sleep(86400000);
        } catch (InterruptedException e) {
            logger.fatal("Interrupted Exception: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        // Grab our endpoints file and parse it into our POJO.
        // TODO: Host this file somewhere it can be both queried by this service and updated by others.
        File endpointsFile = new File("datajsonendpoints.json");
        ObjectMapper endpointMapper = new ObjectMapper();
        List<DataJsonEndpoint> endpoints = null;
        try {
            endpoints = endpointMapper.readValue(endpointsFile, new TypeReference<List<DataJsonEndpoint>>() {
            });
        } catch (IOException e) {
            logger.fatal("IOException: " + e.getMessage());
        }
        // Loop through all of our endpoints
        for (DataJsonEndpoint endpoint : endpoints) {
            // Test the URL to ensure we get a status code 200 (OK).
            // This prevents crashes when sites are down for maintenance.
            URL endpointURL = null;
            try {
                endpointURL = new URL(endpoint.getUrl());
            } catch (MalformedURLException e) {
                logger.fatal("MalformedURLException at URL " + endpoint.getUrl() + " : " + e.getMessage());
                continue;
            }
            HttpURLConnection connection = null;
            int responseCode = 0;
            try {
                connection = (HttpURLConnection) endpointURL.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                responseCode = connection.getResponseCode();
            } catch (IOException e) {
                logger.warn("IOException at URL " + endpointURL +" : " + e.getMessage());
                continue;
            }
            if (responseCode != 200) {
                logger.warn("URL " + endpointURL + " responded with status code: " + responseCode);
                continue;
            }
            // Now we can actually extract the data and load it into our data.json POJO.
            ObjectMapper dataJsonMapper = new ObjectMapper();
            dataJsonMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            dataJsonMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            List<DataJsonSingleEntry> dataJson = null;
            try {
                dataJson = dataJsonMapper.readValue(endpointURL, new TypeReference<List<DataJsonSingleEntry>>() {
                });
            } catch (IOException e) {
                logger.warn("IOException mapping " + endpointURL +" : " + e.getMessage());
                continue;
            }

            for (DataJsonSingleEntry entry : dataJson) {
                //TODO: Clean up data, create new object to send to SOLR instance.
            }
        }
    }
}