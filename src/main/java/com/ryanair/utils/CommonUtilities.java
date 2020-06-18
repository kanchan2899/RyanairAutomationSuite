package com.ryanair.utils;

import java.util.Date;

public class CommonUtilities {

    public static String currentDate(){
        return new Date().toString().replace(" ", "_").replace(":", "_");
    }
}
