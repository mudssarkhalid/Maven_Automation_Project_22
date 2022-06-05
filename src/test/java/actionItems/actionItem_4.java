package actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

/*
You will be using Weight Watchers for this action item
Create an Array List to store 3 different real zipCode
Using for/while loop I want you to iterate through following test steps multiple times
Use Chrome Options to set your chrome driver with maximize and incognito (for mac users just use incognito and you can use
full screen command after navigate)
Also, every WebElement just like we did in class must go inside individual try catch exception
**use proper wait statement whenever it is needed**
Test Steps:
1. Navigate to weightwatchers.com
2. Click on Attend dropdown on top left of the page
3. Click on Unlimited Workshops from the dropdown
4. On Next page click on Studio link
5. Clear the field and enter your zipcode //this is where you pass your zipCode.get(i)
6. Click on Search arrow
7. Click on the specific link for the studios //you can use findElements with get() command locating by common property

**use if condition so for each iteration, you are clicking on different studio link. For instance, if i == 0 then click on second
studio link
*If i == 1 then click on the third studio link
**if i == 2 then click on first (0) studio link
** you will be storing your driver.findElements in WebElement variable to click on studio link on multiple if conditions for three
different zipcode //you can use this on one single try catch exception since you are location same findElements just the index
number is different based on your if conditions
7. Capture the entire address on a variable and print out the address
8. Now scroll to the bottom using JavascriptExecutor and then I want you to capture the entire table with days and hours for
the virtual studio and print it out on another separate print statement inside separate try catch
 */
public class actionItem_4 {
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
//define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        //declare javascriptexecutor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        for (int i = 0; i < codes.size(); i++) {

//navigate to weightwatchers.com
            driver.navigate().to("https://www.weightwatchers.com");
            Thread.sleep(2000);

            //handle exception for clicking Attend
            try {
                driver.findElement(By.xpath("//*[@data-e2e-name='attend']")).click();
            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to locate attend " + e);
            }//end of exception

            Thread.sleep(500);

            //handle exception for clicking Unlimited Workshops
            try {
                driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']")).click();
            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to locate Unlimited Workshops" + e);
            }//end of exception

            Thread.sleep(2000);

            //handle exception for clicking Studio
            try {
                driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']")).click();
            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to locate Studio" + e);
            }//end of exception

            //handle exception for clearing the search box and entering the zip codes
            try {
                WebElement Search = driver.findElement(By.xpath("//*[@id='location-search']"));
                Search.clear();
                Search.sendKeys(codes.get(i));
            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to locate Search" + e);
            }//end of exception

            //handle exception for submit
            try {
                driver.findElement(By.xpath("//*[@type='submit']")).click();
            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to locate submit" + e);
            }//end of exception
            Thread.sleep(2000);


            //handle exception for clicking the studio link corresponding to the zip codes index
            try {
                WebElement studio = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(i);
                studio.click();
            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to locate studio link" + e);
            }//end of exception
            Thread.sleep(2000);

            //handle exception for printing the studio address
            try {
                String addy = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                System.out.println("The address of the studio is " + addy);
            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to locate studio address" + e);
            }//end of exception
            Thread.sleep(2000);

            //handle exception for scrolling to the virtual studio schedule
            try {
                WebElement schedule = driver.findElement(By.xpath("//*[@class='title-bEfSM']"));
                jse.executeScript("arguments[0].scrollIntoView(true);", schedule);
                Thread.sleep(500);


                String workshops = driver.findElement(By.xpath("//*[@id='virtualWorkshopSchedule']")).getText();
                System.out.println("The virtual workshop schedule is " + workshops);

            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to locate virtual studio schedule" + e);
            }//end of exception

        }//loop
        driver.quit();
    }//main
}//class
