package com.ryanair.utils;

import java.util.Date;

/**
 * This class provides a common utility methods for use across the project;
 */
public class CommonUtilities {

    public static String currentDate(){
        return new Date().toString().replace(" ", "_").replace(":", "_");
    }
}
