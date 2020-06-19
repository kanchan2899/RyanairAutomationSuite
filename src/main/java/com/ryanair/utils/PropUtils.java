package com.ryanair.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class reads the application properties files.
 */
public class PropUtils {

    public static Properties properties;
    public static String propFilePath = "application.properties";

    public PropUtils() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(propFilePath));
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public String getProperty(String key){
        return  properties.getProperty(key);
    }

}
