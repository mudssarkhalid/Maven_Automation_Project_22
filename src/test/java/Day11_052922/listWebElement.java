package Day11_052922;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class listWebElement {
    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;

    //before suite will set the driver
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
    }//BeforeSuite

    @Test
    public void USPS_Tabs_Count() throws InterruptedException {
        //navigate to USPS
        driver.navigate().to("https://www.usps.com");
        //declare explicit wait for the tabs
        WebDriverWait wait = new WebDriverWait(driver,10);
        //store the navigation tabs as a list to get the count
        List<WebElement> tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
        //print the tab count
        System.out.println("Tabs count is " + tabsCount.size());
        for (int i = 0; i<tabsCount.size(); i++){
            //navigate to USPS
            driver.navigate().to("https://www.usps.com");
            //store the navigation tabs as a list to get the count
            List<WebElement> tabsCount2 = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
            /* Can also do it this way, without using a different variable inside the for loop
            tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
             */
            //click on each tab
            tabsCount2.get(i).click();
            Thread.sleep(3000);
        }
    }//Test

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }

}//class
