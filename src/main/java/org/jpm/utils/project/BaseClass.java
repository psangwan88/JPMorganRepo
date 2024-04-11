package org.jpm.utils.project;

import org.jpm.utils.web.Web_Lib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.util.concurrent.TimeUnit;

public class BaseClass implements ProjectVariables{
    TestContextLib testContextLib;
    public BaseClass(TestContextLib testContextLib){
        this.testContextLib = testContextLib;
    }

    /**
    Description : this method will take a screenshot and attach to the report for current scenario
    Params : webdriver : instance of webdriver
            message : if any message to be printed with image
    Return : none
    */
    public void attachScreenShot(WebDriver driver, String message) {
        try {
            byte[] screenshot = new Web_Lib().getScreenShot(driver);
            scenarioList.get().attach(screenshot, "image/png", message);
        } catch (WebDriverException noSupportScreenshot) {
            System.err.println(noSupportScreenshot.getMessage());
        }
    }
    /**
        Description : this method will take a screenshot and attach to the report for current scenario with default message
        Params : webdriver : instance of webdriver
        Return : none
    */
    public void attachScreenShot(WebDriver driver){
        attachScreenShot(driver,"screenshotAttached");
    }

    /**
    Description : this method will launch the broser and do all the set ups on browser and initialise page classes as well
    Params :none
    Return : none
*/
    public WebDriver launchBrowser_setUp(){
        testContextLib.setDriver(testContextLib.getWebLib().launchBrowser(browser,headless));
        testContextLib.initializePageObjects();
        testContextLib.getDriver().manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
        if(!headless)
            testContextLib.getDriver().manage().window().maximize();
        return testContextLib.getDriver();
    }



}
