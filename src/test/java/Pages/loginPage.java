package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends CommonMethods {

    public loginPage()
    {
        PageFactory.initElements(driver,this); //we are telling to initialize each webElement of the current page with the driver, the reason we are using constructor
    }
    //---------------------------Page Factory Model to store webElements------------------------------------------
    @FindBy(id = "txtUsername")
    public WebElement usernameTextBox;
    @FindBy(id = "txtPassword")
    public WebElement passwordTextBox;
    @FindBy(id = "btnLogin")
    public WebElement loginBtn;
    @FindBy(id = "welcome")
    public WebElement welcomeIcon;
    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutLink;


}
