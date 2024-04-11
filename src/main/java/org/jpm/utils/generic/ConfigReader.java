package org.jpm.utils.generic;

import java.io.*;
import java.util.Properties;

public class ConfigReader {


    private static Properties properties = null;

    /**
    Description : reads the config file based on filename, expectation is its present in config directory else need to pass whole pat
    Params : file name, name of file in config directory
    Return : none
    */
    public ConfigReader(String fileName) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String propertyFilePath = "config" + File.separator + fileName + ".properties";

        try {
            fileReader = new FileReader(propertyFilePath);
            bufferedReader = new BufferedReader(fileReader);
            properties = new Properties();

            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    /**
    Description : this method will give the object to config reader file
    Params : file name, name of file in config directory
    Return : poperties object which points to the file which is mentioned in input
    */
    public static Properties getPropertiesObject(String fileName){
        if(properties == null)
            new ConfigReader(fileName);
        return properties;
    }
}
