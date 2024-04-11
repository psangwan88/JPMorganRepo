package org.jpm.stepDefs;

import io.cucumber.java.en.*;
import org.jpm.utils.project.BaseClass;
import org.jpm.utils.project.TestContextLib;
import org.testng.Assert;

public class GooglePageSteps extends BaseClass {

    TestContextLib testContextLib;
    public GooglePageSteps(TestContextLib testContextLib){
        super(testContextLib);
        this.testContextLib = testContextLib;
    }



    @Then("User should find less than two articles confirming it to be fake news")
    public void user_should_find_less_than_two_articles_confirming_it_to_be_fake_news() {
        int count = testContextLib.getGooglePage().getArticleCounts();
        String msg = "Article count should be less than 2, actual count " + count + ", article searched " + testContextLib.getTest_data("article");
        Assert.assertTrue(count < 2, msg);
    }

    @When("User search for the news title on Google")
    public void user_search_for_the_news_title_on_google() {
        testContextLib.getWebLib().get("https://www.google.com");
        testContextLib.getGooglePage().searchText(testContextLib.getTest_data("article").toString());
    }
    @Then("User should find at least two articles confirming the news")
    public void user_should_find_at_least_two_articles_confirming_the_news() {
        int count = testContextLib.getGooglePage().getArticleCounts();
        String msg = "Article count should be greater than 2, actual count " + count + ", article searched " + testContextLib.getTest_data("article");
        Assert.assertTrue(count > 2, msg);
    }

    @Given("User search for fake news with title {string}")
    public void user_search_for_fake_news_with_title(String news) {
        testContextLib.setTest_data("article",news);
        testContextLib.getWebLib().get("https://www.google.com");
        testContextLib.getGooglePage().searchText(news);
    }
    @Then("User should find zero results for this fake news")
    public void user_should_find_zero_results_for_this_fake_news() {
        int count = testContextLib.getGooglePage().getArticleCounts();
        String msg = "No Article should be found, actual count " + count + ", article searched " + testContextLib.getTest_data("article");
        Assert.assertTrue(count == 0, msg);

    }
}
