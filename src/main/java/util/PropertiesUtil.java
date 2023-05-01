package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    static Properties properties;
    static {
        //Loading the properties file

        properties = new Properties();
        String propertiesFilePath = "src/main/resources/framework.properties";
        FileInputStream fis;
        try {
            fis = new FileInputStream(propertiesFilePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getURL(){
        return properties.getProperty("url","https://www.google.com/");
    }

    public static String getBrowserName(){
        return properties.getProperty("browser","chrome");
    }

    public static int getExplicitTimeoutInSeconds(){
        return Integer.parseInt(properties.getProperty("explicitWaitTime","5"));
    }
}
