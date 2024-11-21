package com.cs.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.cs.enums.ConfigProperties;
import com.cs.exceptions.PropertyFileValueException;

public final class PropertyUtils {

    private PropertyUtils() {}

    private static final Properties prop = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try (InputStream input = ResourceLoader.getResource("properties/ConfigProperties.properties")) {
            prop.load(input);

            for (String key : prop.stringPropertyNames()) {
                if (System.getProperties().containsKey(key)) {
                    prop.setProperty(key, System.getProperty(key));
                }
            }

            for (Map.Entry<Object, Object> entry : prop.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyMapValue(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.toString().toLowerCase()))) {
            throw new PropertyFileValueException("The Property value of key " + key + " is not found in config properties file");
        }
        return CONFIGMAP.get(key.toString().toLowerCase());
    }
}
