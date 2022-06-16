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

public class UBSWealthManagementPage extends Reusable_Annotations {
    //declare the ExtentTest for each page object class
    ExtentTest logger;
    public static int timeout = 10;
    //create a constructor method that will reference the same name as your class, so you
    //can make your page object class methods static when you call it in your test class

    public UBSWealthManagementPage(WebDriver driver){
        //page factory function for page object
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//constructor

    //define all the WebElements using @FindBy concept
    @FindBy(xpath = "//*[@class='fullbleedVideoWrapper']")
    WebElement videoHeader;
    @FindBy(xpath = "//*[@name='stop video']")
    WebElement pauseButton;
    @FindBy(xpath = "//*[@name='play video']")
    WebElement playButton;
    @FindBy(xpath = "//*[@id='headerLoginToggleButton']")
    WebElement loginsButton;
    @FindBy(xpath = "//*[@class='metaNav__item metaNav__item--firstLevel metaNav__item--dropdown metaNav__item--dropdownLogin js-login-wrapper menu-is-active']")
    WebElement loginsDropDown;
    @FindBy(xpath = "//*[@class='catNav__label catNav__hl--contactIcon']")
    WebElement contactButton;
    @FindBy(xpath = "//*[@class='catNav__item catNav__item--level1 catNav__item--relative menu-is-active']")
    WebElement contactDropDown;

    public void headerVisible(){
        POM_Reusable_Actions_Loggers.visibilityOfElement(driver,videoHeader,logger,"Video Header");
    }

    public void pauseButtonVisible(){
        POM_Reusable_Actions_Loggers.visibilityOfElement(driver,pauseButton,logger,"Pause Button");
    }

    public void playButtonVisible(){
        POM_Reusable_Actions_Loggers.visibilityOfElement(driver,playButton,logger,"Pause Button");
    }

    public void clickOnPauseButton(){
        POM_Reusable_Actions_Loggers.clickAction(driver, pauseButton,logger,"Pause Button");
    }//class

    public void clickOnPlayButton(){
        POM_Reusable_Actions_Loggers.clickAction(driver, playButton,logger,"Play Button");
    }//class

    public void loginsButtonVisible(){
        POM_Reusable_Actions_Loggers.visibilityOfElement(driver,loginsButton,logger,"Logins Button");
    }//class

    public void clickOnLogins(){
        POM_Reusable_Actions_Loggers.clickAction(driver,loginsButton,logger,"Logins Button");
    }//class

    public void dropDownVisible(){
        POM_Reusable_Actions_Loggers.visibilityOfElement(driver,loginsDropDown,logger,"Logins Dropdown");
    }//class

    public void contactVisible(){
        POM_Reusable_Actions_Loggers.visibilityOfElement(driver,contactButton,logger,"Contact Button");
    }

    public void clickOnContact(){
        POM_Reusable_Actions_Loggers.clickAction(driver,contactButton,logger,"Contact Button");
    }

    public void contactDropDownVisible(){
        POM_Reusable_Actions_Loggers.visibilityOfElement(driver,contactDropDown,logger,"Contact Drop Down");
    }

    public void visibilityOfContactOptions(String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isDisplayed();
        try {
            if (elementState == true){
                System.out.println("The " + elementName + " is visible.");
                logger.log(LogStatus.PASS,elementName + " is visible.");
            }else {
                System.out.println("The " + elementName + " is not visible.");
                //logger.log(LogStatus.FAIL,elementName + " is not visible.");
            }//conditional
        } catch (Exception e){
            logger.log(LogStatus.FAIL,"Failed to verify visibility of " + elementName + e);
        }//exception
    }//method

    public void visibilityOfContactFields(String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isDisplayed();
        try {
            if (elementState == true){
                System.out.println("The " + elementName + " is visible.");
                logger.log(LogStatus.PASS,elementName + " is visible.");
            }else {
                System.out.println("The " + elementName + " is not visible.");
                //logger.log(LogStatus.FAIL,elementName + " is not visible.");
            }//conditional
        } catch (Exception e){
            logger.log(LogStatus.FAIL,"Failed to verify visibility of " + elementName + e);
        }//exception
    }//method

}//parent class
