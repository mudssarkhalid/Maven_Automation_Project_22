package Day9_052222;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;

public class USPS_Reusable_Concepts {
    public static void main(String[] args) {

        //setting teh local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        //navigate to USPS
        driver.navigate().to("https://www.usps.com");

        //hovering over quick tools
        Reusable_Actions.mouseHover(driver,"//*[text()='Quick Tools']","Quick Tools");

        //hover over send tab
        Reusable_Actions.mouseHover(driver,"//*[@id='mail-ship-width']","Send Tab");

        //click on calculate a price
        Reusable_Actions.clickAction(driver,"//li[@class='tool-calc']","Calculate a Price");

        //enter the zip code
        Reusable_Actions.sendKeysAction(driver,"//*[@id='Origin']","11003","Zip Code");

        //print the header text
        String result = Reusable_Actions.getTextAction(driver,"//*[@class='header-usps row']","Header Info");
        System.out.println("My header text is " + result);
    }//main
}//class
