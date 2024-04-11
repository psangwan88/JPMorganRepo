package org.jpm.utils.project;

import io.cucumber.java.Scenario;
import org.jpm.utils.generic.ConfigReader;

import java.util.Properties;

public interface ProjectVariables {

    /**
     * project level variables
     */
    public static Properties props = ConfigReader.getPropertiesObject("config");
    static String browser = props.getProperty("browser");
    static String url = props.getProperty("url");
    static boolean headless = props.getProperty("url").contains("true") ? true : false;

    static ThreadLocal<Scenario> scenarioList = new ThreadLocal<Scenario>();
    static int timeInSec = Integer.valueOf(props.getProperty("waittime"));
    static boolean debug = props.getProperty("debug").contains("true") ? true : false;
}
