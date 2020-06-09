package com.pmg.mymusictaste.util;

import java.io.InputStream;
import java.util.Properties;

import com.google.api.services.youtube.YouTube.Search;

public class PrivateProperties {

    public static String PROPERTIES_FILENAME = "private.properties";

    public static String getPrivateProperty(String property){
        Properties properties = new Properties();
        try {
            InputStream in = Search.class.getResourceAsStream("/"+PROPERTIES_FILENAME);
            properties.load(in);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }

}