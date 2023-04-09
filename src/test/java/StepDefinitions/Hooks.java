package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends CommonMethods {

    @Before
    public void preCondition () {
        openBrowserAndLaunchApplication();
    }

    @After
    public void postConditions () {
        closeBrowser();
        //you can generate report, take screenshot by creating a method here....before closing a tab
    }
}
