package Day4_050722;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) {

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver();

        //go to Google home page
        driver.navigate().to("https://www.google.com");

        //maximize the driver
        driver.manage().window().maximize(); //for mac use fullscreen

        //enter cars into the search box
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        //driver.findElement(By.xpath("//input[@name='q']")).sendKeys("cars");

        //submit the enter button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //get the text of search results and print it out
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println( searchResult + " search results found");

        //extract the number and print the number only
        String[] arrayResult = searchResult.split(" ");
        System.out.println("My search number is " + arrayResult[0]);
        //quit the driver
        //driver.quit();

    }//end of main method
}//end of class
