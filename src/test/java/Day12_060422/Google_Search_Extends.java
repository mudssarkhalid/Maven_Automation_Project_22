package Day12_060422;

import ReusableClasses.Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotations;
import org.testng.annotations.Test;


public class Google_Search_Extends extends Reusable_Annotations {

    @Test(priority = 1)
    public void GoogleSearchForKeyword(){
        driver.navigate().to("https://www.google.com");
        //enter a keyword on search field
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //submit the go button
        Reusable_Actions_Loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Search Button");
    }//end of test 1


    /*dependsOnMethods is used when  following @Test is dependent on previous @Test method.
    If the first test fails,the dependent test will get skipped
     */

    @Test(dependsOnMethods = "GoogleSearchForKeyword")
    public void GoogleCaptureSearchNumber(){
        //capture search result
        String result = Reusable_Actions_Loggers.getTextAction(driver,"//*[@id='result-stats']",logger,"Search Result Text");
        //split the result by single space and print out the search number
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
    }//end of test 2
}//end of class
