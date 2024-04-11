package org.jpm.stepDefs;

import io.cucumber.java.en.Given;
import org.jpm.utils.project.BaseClass;
import org.jpm.utils.project.ProjectVariables;
import org.jpm.utils.project.TestContextLib;
import org.jpm.utils.web.Web_Lib;
import org.openqa.selenium.WebDriver;

public class GenericSteps extends BaseClass implements ProjectVariables {

    WebDriver driver;
    Web_Lib webLib = new Web_Lib();
    TestContextLib testContextLib;
    public GenericSteps(TestContextLib testContextLib){
        super(testContextLib);
        this.testContextLib = testContextLib;
    }

    @Given("User launches the browser")
    public void user_launches_the_browser() {
        launchBrowser_setUp();
    }

}
