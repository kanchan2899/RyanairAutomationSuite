package com.ryanair.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {

    public static Properties properties;
    public static String propFilePath = "application.properties";

    public void Properties() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(propFilePath));
            System.out.println("Loaded");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public String getProperty(String key){
        return  properties.getProperty(key);
    }

}
