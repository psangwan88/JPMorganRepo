package org.jpm.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsPage {

    private WebDriver driver;
    public NewsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@class = 'fc-item__title']//*[@class = 'js-headline-text']")
    private WebElement newsArticleText;

    @FindBy(xpath = "//*[@class = 'fc-item__title']//*[@class = 'js-headline-text']")
    private List<WebElement> newsArticleTextList;

    @FindBy(xpath = "//*[@class = 'fc-item__title']//*[@class = 'js-headline-text']/../..")
    private WebElement newsArticleUrl;

    @FindBy(xpath = "//*[@class = 'fc-item__title']//*[@class = 'js-headline-text']/../..")
    private List<WebElement> newsArticleUrlList;

    @FindBy(xpath = "//*[contains(text(),'Yes, I’m happy')]")
    private WebElement cookieButton;

    @FindBy(xpath = "//*[contains(@id,'sp_message_iframe')]")
    private WebElement iframe_cookies;


    public String getFirstNewsText(){
        closeIfCookiePopUpAppears();
        return newsArticleText.getText();
    }

    /**
    Description : this method will close the cookies pop up if it appears
    Params : none
    Return : none
    */
    public void closeIfCookiePopUpAppears(){
        if(isIFramePresent()){
            driver.switchTo().frame(iframe_cookies);
            cookieButton.click();
            driver.switchTo().defaultContent();
        }
    }
    public boolean isIFramePresent(){
        try {
            if(iframe_cookies.isDisplayed())
                return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }

}
