package org.jpm.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.jpm.utils.project.BaseClass;
import org.jpm.utils.project.ProjectVariables;
import org.jpm.utils.project.TestContextLib;

public class NewsPageSteps extends BaseClass implements ProjectVariables {

    TestContextLib testContextLib;
    public NewsPageSteps(TestContextLib testContextLib){
        super(testContextLib);
        this.testContextLib = testContextLib;
    }



    @Given("User open the news page on {string}")
    public void user_open_the_news_page_on(String url) {
        testContextLib.getWebLib().get(url);
    }
    @When("User extract the title of the first news article")
    public void user_extract_the_title_of_the_first_news_article() {
        String text = testContextLib.getNewsPage().getFirstNewsText();
        if(text != null && text != "")
            testContextLib.setTest_data("article",text);
    }

//    public static void main(String[] args) {
//        System.out.println("true".contains("true") ? true : false);
//    }

}
