package Day10_052822;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_Example {

    //declare the local driver outside all annotations so that it can be reusable
    //with other annotation methods
    WebDriver driver;

    //test case 1: navigate to google and enter keyword
    @Test(priority = 1)
    public void SearchForKeyword(){
        driver.navigate().to("https://www.google.com");
        //enter a keyword on search field
        Reusable_Actions.sendKeysAction(driver,"//*[@name='q']","BMW","Search Field");
        //submit the go button
        Reusable_Actions.submitAction(driver,"//*[@name='btnK']","Google Search Button");
    }//end of test 1

    @Test(priority = 2)
    public void CaptureSearchNumber(){
        //capture search result
        String result = Reusable_Actions.getTextAction(driver, "//*[@id='result-stats']","Search Result Text");
        //split
        String [] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
    }//end of test 2

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
    }//before suite

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of after suite


}//class