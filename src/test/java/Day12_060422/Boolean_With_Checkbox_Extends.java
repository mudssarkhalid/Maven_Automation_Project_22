package Day12_060422;

import ReusableClasses.Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotations;
import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Boolean_With_Checkbox_Extends extends Reusable_Annotations {

    @Test
    public void Yahoo_Checkbox_Verification() throws InterruptedException {
        //navigate to Yahoo
        driver.navigate().to("https://www.yahoo.com");
        //click on sign in
        Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Sign in']",logger,"Sign in");
        //verify if the checkbox is selected or not
        WebDriverWait wait = new WebDriverWait(driver,10);
        Boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
        System.out.println("Is element checked? " + elementState);
    }//Test
}//class
