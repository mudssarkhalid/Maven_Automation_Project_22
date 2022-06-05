package actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class actionItem_3_subString {

    public static void main(String[] args) throws InterruptedException{

        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("Surfing");
        hobbies.add("Bowling");
        hobbies.add("Photography");
        hobbies.add("Gym");
        hobbies.add("Video games");

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        //options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-fullscreen");
        options.addArguments("headless");
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
            //pass the length of the search results String into an int
            int length = arrayResult[0].length();
            //Print the number of search results with the substring method
            System.out.println(searchResult);
            System.out.println("The number of search results for " + hobbies.get(i) + " is " + searchResult.substring(0,length));

            //17,000,000
            //0123456789
            System.out.println("My length is " + length);
        }//end of loop

        //quit the driver
        driver.quit();

    }//end of main method
}
