package org.jpm.utils.project;

import org.jpm.pages.GooglePage;
import org.jpm.pages.NewsPage;
import org.jpm.utils.web.Web_Lib;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class TestContextLib {

    private WebDriver driver;
    private GooglePage googlePage;
    private NewsPage newsPage;
    private Web_Lib webLib;
    private String testName;
    private Map<String, Object> test_data;

    public WebDriver getDriver(){
        return driver;
    }

    public void quitDriver(){
        driver.quit();
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
    public GooglePage getGooglePage(){
        return googlePage;
    }
    public NewsPage getNewsPage(){
        return newsPage;
    }

    public Web_Lib getWebLib(){
        if(webLib == null)
            return new Web_Lib();
        return webLib;
    }

    /**
    Description : initiallises all relevant class instances
    Params : none
    Return : none
    */
    public void initializePageObjects(){
        googlePage = new GooglePage(driver);
        newsPage = new NewsPage(driver);
        webLib = new Web_Lib(driver);
        test_data = new HashMap<String,Object>();
    }

    public void setTestName(String name){
        this.testName = name;
    }
    public String getTestName(){
        return testName;
    }

    public void setTest_data(String key, Object value) {
        test_data.put(key, value);
    }

    public Object getTest_data(String key){
        return test_data.get(key);
    }


}
