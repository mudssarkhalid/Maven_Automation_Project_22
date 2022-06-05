package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class findElements {
    public static void main(String[] args) throws InterruptedException{

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
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(1000);

        //click on Images link using class property with index of 1
        //to ignore the white space in the property value we can use contains command in xpath
        driver.findElements(By.xpath("//li[contains(@class,'scope')]")).get(0).click();

        //quit the driver
     //   driver.quit();

    }//end of main method

}
