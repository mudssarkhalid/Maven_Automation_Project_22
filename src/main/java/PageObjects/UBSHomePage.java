package PageObjects;

import ReusableClasses.POM_Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class UBSHomePage extends Reusable_Annotations {
    //declare the ExtentTest for each page object class
    ExtentTest logger;

    //create a constructor method that will reference the same name as your class, so you
    //can make your page object class methods static when you call it in your test class

    public UBSHomePage(WebDriver driver){
        //page factory function for page object
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//constructor

    //define all the WebElements using @FindBy concept
    @FindBy(xpath = "//*[@aria-controls='mainmenu-navContent0']")
    WebElement wealthManagement;

    public void clickOnWealthManagement(){
        POM_Reusable_Actions_Loggers.clickAction(driver, wealthManagement,logger,"Wealth Management Dropdown");
    }//class
/*
    public void clickOnDropDownValue(String Locator, String elementName){
        POM_Reusable_Actions_Loggers.clickAction(driver,Locator,logger,elementName);
    }
    */

    public void clickOnDropDownValue(String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            POM_Reusable_Actions_Loggers.clickAction(driver,element,logger,xpath);
            logger.log(LogStatus.PASS,"Successfully clicked on drop down value " + elementName);
        } catch(Exception e){
            logger.log(LogStatus.FAIL,"Failed to click on drop down value " + elementName + e);
        }//exception
    }//clickOnDropDownValue

}//class
