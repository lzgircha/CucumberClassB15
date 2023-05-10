package StepDefinitions;
import Pages.AddEmployeePage;
import Pages.loginPage;

public class PageInitializer {
    //this class will manage the object creation of different page Objects in out Framework.
    //Instead of calling the page objects again and again, this class will take care of that step.

    public  static loginPage login;
    public static AddEmployeePage addEmployeePage;

    public  static void initializePageObjects()
    {
        login = new loginPage();
        addEmployeePage=new AddEmployeePage();
    }
}

