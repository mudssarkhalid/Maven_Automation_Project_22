package Day10_052822;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestNG_Example_2 {

    //declare the local driver outside all annotations so that it can be reusable
    //with other annotation methods
    WebDriver driver;

    //test case 1: navigate to google and enter keyword
    @Test

    public void SearchForKeyword(){
        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Tesla");
        cars.add("Toyota");

        for (int i = 0; i<cars.size(); i++){
            driver.navigate().to("https://www.google.com");
            //enter a keyword on search field
            Reusable_Actions.sendKeysAction(driver,"//*[@name='q']",cars.get(i),"Search Field");
            //submit the go button
            Reusable_Actions.submitAction(driver,"//*[@name='btnK']","Google Search Button");
            //capture search result
            String result = Reusable_Actions.getTextAction(driver, "//*[@id='result-stats']","Search Result Text");
            //split
            String [] arrayResult = result.split(" ");
            System.out.println("Search number is " + arrayResult[1]);
        }//for
    }//test

    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
    }//before suite

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of after suite

}//class