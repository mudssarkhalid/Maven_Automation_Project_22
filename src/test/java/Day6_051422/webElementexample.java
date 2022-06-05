package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class webElementexample {
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
        driver.navigate().to("https://mortgagecalculator.org");
        Thread.sleep(1000);

        //click, clear and enter new vallue on Home value field
        WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
        homeValue.click();
        homeValue.clear();
        //Thread.sleep(1500);
        homeValue.sendKeys("450000");

        //click on % radio button
        driver.findElement(By.xpath("//*[@value='percent']")).click();

        //click, clear and enter new datea on down payment field
        WebElement downPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        downPayment.click();
        downPayment.clear();
        downPayment.sendKeys("5");

        driver.quit();
    }
}
