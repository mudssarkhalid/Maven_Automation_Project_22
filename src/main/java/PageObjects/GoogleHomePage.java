package PageObjects;

import ReusableClasses.POM_Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends Reusable_Annotations {
    //declare the ExtentTest for each page object class
    ExtentTest logger;

    //create a constructor method that will reference the same name as your class so you
    //can make your page object class methods static when you call it in your test class

    public GoogleHomePage(WebDriver driver){
        //page factory function for page object
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;

    }//constructor

    //define all the webelements using @Findby concept
    @FindBy(xpath = "//*[@name='q']")
    WebElement searchField;
    @FindBy(xpath = "//*[@name='btnK']")
    WebElement googleSearchButton;

    /*
    If you need to locate an element by a property that has multiple matches:
    @FindBy(xpath = "//*[@name='q']")
    List<WebElement> searchField

    is called in the test class by

    public void searchUserValue(String uservalue){
        POM_Reusable_Actions_Loggers.sendKeysAction(driver,searchField.get(0),uservalue,logger,"Search Field");
     */

    public void enterUserValue(String uservalue) {
        POM_Reusable_Actions_Loggers.sendKeysAction(driver, searchField, uservalue, logger, "Search Field");
    }//class

    public void clickSearch() {
        POM_Reusable_Actions_Loggers.submitAction(driver, googleSearchButton,logger,"Search Button");
    }//class
}//parent class
