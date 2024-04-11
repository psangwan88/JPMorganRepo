package org.jpm.hooks;

import io.cucumber.java.*;
import org.jpm.utils.project.BaseClass;
import org.jpm.utils.project.ProjectVariables;
import org.jpm.utils.project.TestContextLib;

public class Hooks extends BaseClass implements ProjectVariables {

    TestContextLib testContextLib;
    public Hooks(TestContextLib testContextLib){
        super(testContextLib);
        this.testContextLib = testContextLib;
    }


    @Before
    public void beforeTest(Scenario scenario){
        System.out.println("Before the test");
        scenarioList.set(scenario); // setting up scenairo in thread local to be used anywhere in project
    }

    @After
    public void afterTest(Scenario scenario){
        System.out.println("After the test");
        if(scenario.isFailed()) {
            attachScreenShot(testContextLib.getDriver(),"Screenshot For failure");
        }
        if(testContextLib.getDriver() != null)
            testContextLib.quitDriver();
    }

    @BeforeStep
    public void beforeStep(){
//        System.out.println("Before the step");
    }

    @AfterStep
    public void afterStep(){
        if(debug) { // only to be used when debugging and running single scenario
            attachScreenShot(testContextLib.getDriver(),"Screenshot after step");
        }
    }
}
