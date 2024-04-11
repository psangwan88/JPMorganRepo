package org.jpm.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions( features = {"src/test/resources/features/"},
        glue = {"org.jpm.stepDefs", "org.jpm.hooks"},
        plugin = {
                "pretty",
                "html:CucumberReports.html",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "timeline:target/test-output-thread/"
        }
//        , tags = "@positive"

//        ,dryRun = true
)


public class TestRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}