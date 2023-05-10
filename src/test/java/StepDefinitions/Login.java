package StepDefinitions;

import Pages.loginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Login extends CommonMethods {

    @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {

        openBrowserAndLaunchApplication();
    }

    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {
        //loginPage login = new loginPage();

        sendText(login.usernameTextBox, ConfigReader.getPropertyValue("username"));

        sendText(login.passwordTextBox, ConfigReader.getPropertyValue("password"));
    }

    @When("click on login button")
    public void click_on_login_button() {
        //loginPage login = new loginPage();
        doClick(login.loginBtn);
    }

    @Then("use is logged in successfully into the application")
    public void use_is_logged_in_successfully() {
        boolean userloggedIn = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).isDisplayed();
        if (userloggedIn) {
            System.out.println("User is logged in Successfully");
        }
    }
    @Then("close the browser")
    public void close_the_browser() {
      closeBrowser();
    }

    @When("user enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String username, String password) {

       // loginPage login = new loginPage();
        sendText(login.usernameTextBox, username);
        sendText(login.passwordTextBox, password);
    }
    @When("user enters username and password and verifies login")
    public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) {
        //loginPage login = new loginPage();

       List<Map<String,String>> userCredentials =dataTable.asMaps(); //converting data table as Maps and storing it in List of Maps
        for(Map<String,String>userCreds:userCredentials){            //alterating is the next step through for loop
            String username=userCreds.get("username");               //capture key from the map and storing as a variable
            String password=userCreds.get("password");

            sendText(login.usernameTextBox, username);
            sendText(login.passwordTextBox, password);
            doClick(login.loginBtn);
            doClick(login.welcomeIcon);
            doClick(login.logoutLink);
        }

    }
}
