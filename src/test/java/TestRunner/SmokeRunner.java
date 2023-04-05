package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        glue = "StepDefinitions",
        dryRun = false,
        tags = "@testcase2")
//if you want to run two test cases at the same time use "or" Ex. tags = "@testcase1 ot @testcase2"
//through tags you can combine test cases

public class SmokeRunner {
}
//tags option will execute the tagged testcases as mentioned in your runner class