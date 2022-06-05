package Day7_051522;

import com.sun.jna.WString;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FidelisCare_Tabs {
    public static void main(String[] args) throws InterruptedException {

        //set up your chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        //options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-fullscreen");
        //define the web driver I am going to use
        WebDriver driver = new ChromeDriver(options);

        //go to Bing home page
        driver.navigate().to("https://fideliscare.org");
        Thread.sleep(2000);
        //click on shop for a plan
        //we are clicking on index 0 because there are two elements for this xpath
        driver.findElements(By.xpath("//*[text() = 'Shp For a Plan']")).get(0).click();
        //wait
        Thread.sleep(1000);
        //click on Medicaid Managed Care
        driver.findElements(By.xpath("//*[text() = 'Medicaid Managed Care']")).get(0).click();
        //wait
        Thread.sleep(1000);
        //click on search under find a doctor card
        driver.findElement(By.xpath("//*[@href = '/findadoctor']")).click();
        //wait
        Thread.sleep(1000);
        //store new tabs in an array list, we use getWindowHandles method to get a list of tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to the new tab
        driver.switchTo().window(tabs.get(1));
        //click on new search button
        driver.findElement(By.xpath("//*[@class = 'fal fa-search-plus']")).click();
        //wait
        Thread.sleep(1000);
        //close the new tab
        driver.close();
        //tell selenium to target the parent tab again
        driver.switchTo().window(tabs.get(0));
        //click on providers card
        driver.findElement(By.xpath("//*[@class = 'fal fa-stethoscope fa-fw']")).click();
        //wait until provider card is clicked on
        Thread.sleep(1000);

    }//end of main method
}//end of class
