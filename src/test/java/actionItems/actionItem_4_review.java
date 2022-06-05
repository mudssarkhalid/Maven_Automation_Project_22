package actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class actionItem_4_review {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> codes = new ArrayList<>();
        codes.add("11580");
        codes.add("11803");
        codes.add("11010");

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the web driver I am going to use
        WebDriver driver = new ChromeDriver(options);
        //declare javascript executor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //for (int i = 0; i < codes.size(); i++) {

            //navigate to weightwatchers.com
            driver.navigate().to("https://www.weightwatchers.com");
            Thread.sleep(2000);

            try{
                WebElement attendButton = driver.findElement(By.xpath("//*[@da-label='Attend']"));
                attendButton.click();
            }
            catch (Exception e){
                System.out.println("Unable to find the Attend element, " + e);
            }

            try{
                WebElement unlimitedWorkshops = driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']"));
                unlimitedWorkshops.click();
            }
            catch (Exception e){
                System.out.println("Unable to find the Unlimited Workshops element, " + e);
            }

            try{
            WebElement unlimitedWorkshops = driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']"));
            unlimitedWorkshops.click();
             }
            catch (Exception e){
            System.out.println("Unable to find the Unlimited Workshops element, " + e);
            }

        //}loop
    }//main
}//class
