package stepdefinitions;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void setUp() {
        if (TestBase.getDriver() == null) {
            TestBase.setUp();
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String scenarioName = scenario.getName().replaceAll(" ", "_");
            TestBase.captureScreenshot(scenarioName);
        }
        TestBase.tearDown();
    }
}
