package actionItems;

/*
Selenium WebDriver with Java
Action Item
Go to bing.com
Using ArrayList variable with atleast 5 values. You can choose the values for any of the following group such as
country, state, location, city, hobby
By using for or while loop create scenarios as followed
1. Go to bing.com
2. Put few seconds to wait
3. Enter a keyword on a search field
4.Click on Search button
5.Wait few seconds
6.Capture the search message
7. Split and print out only the search number for each values(on print statement mention which values from
arraylist you are printing as well and their search numbers)
8.Outside of the loop quit the driver
 */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class actionItem_3 {
    public static void main(String[] args) throws InterruptedException{

        ArrayList<String>hobbies = new ArrayList<>();
        hobbies.add("Surfing");
        hobbies.add("Bowling");
        hobbies.add("Photography");
        hobbies.add("Lifting weights");
        hobbies.add("Video games");

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        //options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        //go to Bing home page
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(3000);

        for (int i = 0; i < hobbies.size(); i++) {
            //locate element for search field and tvpe the current query
            driver.findElement(By.xpath("//*[@name='q']")).clear();
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobbies.get(i));
            //submit on Bing search button
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            //capture the Bing search and print it
            String searchResult = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //System.out.println("Result is " + searchResult);
            //extract out the number and print the search number only
            String[] arrayResult = searchResult.split(" ");
            System.out.println("Mv search number for " + hobbies.get(i) + " is " + arrayResult[0]);
        }//end of loop

            //quit the driver
            driver.quit();

    }//end of main method
}//end of class
