package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

    @Before
    public void preCondition() {

        openBrowserAndLaunchApplication();
    }

    // Scenario class holds the complete information of your tests execution in Cucumber framework
    @After
    public void postConditions(Scenario scenario) {
        byte[] pic;
        if (scenario.isFailed()) {
            pic = takeScreenshot("failed/" + scenario.getName());
        } else {
            pic = takeScreenshot("passed/" + scenario.getName());
        }
        // attach the screenshot in my report
        scenario.attach(pic, "image/png", scenario.getName());

        closeBrowser();
        //you can generate report, take screenshot by creating a method here....before closing a tab
    }
}
