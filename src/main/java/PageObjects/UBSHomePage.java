package PageObjects;

import ReusableClasses.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public static class UBSHomePage extends Reusable_Annotations {
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
    //declare ArrayList for the unique xpaths of dropdown items
    ArrayList<String> item_xpath = new ArrayList<>();
        item_xpath.add("//*[text()='Homepage']");
        item_xpath.add("//*[text()='Our approach']");
        item_xpath.add("//*[text()='Who we serve']");
        item_xpath.add("//*[text()='Specialized advice']");
        item_xpath.add("//*[text()='Insights']");

    ArrayList<String> item_name = new ArrayList<>();
        item_name.add("Wealth Management Homepage");
        item_name.add("Wealth Management Our approach");
        item_name.add("Wealth Management Who we serve");
        item_name.add("Wealth Management Specialized advice");
        item_name.add("Wealth Management Insights");

    ArrayList<String> item_URL = new ArrayList<>();
        item_URL.add("https://www.ubs.com/us/en/wealth-management.html");
        item_URL.add("https://www.ubs.com/us/en/wealth-management/our-approach.html");
        item_URL.add("https://www.ubs.com/us/en/wealth-management/who-we-serve.html");
        item_URL.add("https://www.ubs.com/us/en/wealth-management/specialized-advice.html");
        item_URL.add("https://www.ubs.com/us/en/wealth-management/insights.html");

    ArrayList<String> item_URL_name = new ArrayList<>();
        item_URL_name.add("Wealth Management Homepage URL");
        item_URL_name.add("Wealth Management Our approach URL");
        item_URL_name.add("Wealth Management Who we serve URL");
        item_URL_name.add("Wealth Management Specialized advice URL");
        item_URL_name.add("Wealth Management Insights URL");
}//class
