package org.ElbablyAcademy.utilities.readers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Logger log = LoggerFactory.getLogger(ConfigManager.class);
    private static final String DEFAULT_PROPERTIES = "config/config.properties";
    private static Properties properties;

    public static void initialize(){
        properties = loadProperties();

        for(String key: properties.stringPropertyNames()){
           if (System.getProperties().containsKey(key)){
               properties.setProperty(key, System.getProperty(key));
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static Properties loadProperties() {
        Properties properties = new Properties();
        try(InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES);) {
            properties.load(stream);
        } catch (Exception e) {
            log.error("unable to read the property file {}", DEFAULT_PROPERTIES, e);
        }
        return properties;
    }
}