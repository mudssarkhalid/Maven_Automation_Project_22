package Day6_051422;

import ReusableLibraries.Reusable_Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class scroll {
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

        //go to mortgagecalculator.org
        driver.navigate().to("https://mortgagecalculator.org");
        Thread.sleep(1000);

        //declare javascriptexecutor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scroll down 400 pixels
        jse.executeScript("scroll(0,400)");

        //wait for browser to scroll
        Thread.sleep(3000);

        //declare a webelement variable that we want to scroll to
        WebElement shareButton = driver.findElement(By.xpath("//*[@id='share_button']"));
        //scroll to share button
        Reusable_Actions.scrollToAction(driver,"//*[@id='share_button']","Share button");

        //jse.executeScript("arguments[0].scrollIntoView(true);", shareButton);
        Thread.sleep(3000);
        //click on the share button
        shareButton.click();
        Thread.sleep(3000);
        //scroll up
        jse.executeScript("scroll(0,-400)");
        Thread.sleep(3000);


        driver.quit();
    }//main
}//class
