package actionItems;

import ReusableClasses.POM_Reusable_Actions_Loggers;
import com.beust.ah.A;
import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class interviewQuestions{
    
    public static void main(String[] args) {
        WebDriver driver = POM_Reusable_Actions_Loggers.setDriver();
        Actions actions = new Actions(driver); 
        WebElement element = driver.findElement(By.xpath("//*[@id='text-box']"));
        actions.moveToElement(element);
        element.click();
        element.sendKeys("User value");


    }
}
