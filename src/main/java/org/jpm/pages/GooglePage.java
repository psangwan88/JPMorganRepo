package org.jpm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    private WebDriver driver;
    public GooglePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@title='Search']")
    private WebElement searchBox;

    @FindBy(id = "result-stats")
    private WebElement articleCount;

    public void searchText(String text){
        searchBox.sendKeys(text );
        searchBox.sendKeys(Keys.RETURN);
    }

    /**
        Description : this method will return the count of articles found on google, if not found will return 0
        Params : none
        Return : integer value
     */
    public int getArticleCounts(){
        try {
            String count = articleCount.getText().split(" ")[1].replace(",", "");
            return Integer.valueOf(count);
        }
        catch (Exception e){
            return 0; // considering google is working fine
        }

    }
}
