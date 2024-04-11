package org.jpm.utils.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Web_Lib {

    public WebDriver driver;

    public Web_Lib(WebDriver driver) {
        this.driver = driver;
    }
    public Web_Lib(){

    }
    public WebDriver launchBrowser(String browser){
       return launchBrowser(browser, false);
    }

    /**
    Description : launches and returns webdriver instace based on inputs
    Params : browser : browser to launch, headless : if need to launch in headless mode
    Return : webdriver instance
    */
    public WebDriver launchBrowser(String browser, boolean headless){
        WebDriver driver = null;
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if(headless)
                    chromeOptions.addArguments("--headless", "--window-size=1644,868");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if(headless)
                    firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                break;

        }
        return driver;
    }

    /**
     Description : this willtake the screen shot and return the byte[] to be attached toreports
     Params : none
     Return : byte[]
     */
    public byte[] getScreenShot(WebDriver driver){
        try {
             return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException noSupportScreenshot) {
            System.err.println(noSupportScreenshot.getMessage());
        }
        return null;
    }

    /**
        Description : naviates to the url mentiond
        Parameters : string : url : url to be navigated to
        Return : None
     */
    public void get(String url){
        driver.get(url);
    }

}
