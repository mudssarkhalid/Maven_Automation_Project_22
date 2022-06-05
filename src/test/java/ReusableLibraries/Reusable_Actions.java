package ReusableLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class Reusable_Actions {

    public static int timeout = 10;

    //reusable function for web driver as a return method
    public static WebDriver setDriver() {
        //setup your chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //run the code headless
        //options.addArguments("--headless");
        //define the web driver I am going to use
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }//method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
        }//exception
    }//method

    //create a click method
    public static void clickAction(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }//exception
    }//method

    //create a submit method
    public static void submitAction(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit

    //create a send keys method
    public static void sendKeysAction(WebDriver driver,String xpath, String userValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }//exception
    }//method

    //create a getText method
    public static String getTextAction(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text " + elementName + " " + e);
        }//exception
        return result;
    }//method


    //create a click by index method
    public static void clickByIndexAction(WebDriver driver,String xpath, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }//exception
    }//end of clickByIndexAction

    //create a switch to tab by index method
    public static void switchToTabByIndex(WebDriver driver, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(indexNumber));
        } catch (Exception e) {
            System.out.println("Unable to switch to tab " + elementName + " " + e);
        }//exception
    }//end of switchToTabByIndex


    //create a verifyTitle method
    public static String verifyTitleAction(WebDriver driver, String contains, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String actualTitle = driver.getTitle();
        try {
            if (actualTitle.contains(contains)){
                System.out.println("The web page title contains " + contains);
            }else {
                System.out.println("The web page title does not contain " + contains + ". The actual title is " + actualTitle);
            }
        } catch (Exception e) {
            System.out.println("Unable to get text " + elementName + " " + e);
        }//exception
        return actualTitle;
    }//method

    //create a selectByText method
    public static void selectByText(WebDriver driver,String xpath, String contains, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select elements = new Select(driver.findElement(By.xpath(xpath)));
            element.click();
            elements.selectByVisibleText(contains);
        } catch (Exception e) {
            System.out.println("Unable to select by " + elementName + " " + e);
        }//exception
    }//method

    public static void scrollToAction(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare javascriptexecutor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //scroll to element
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("Unable to scroll to element " + elementName + " " + e);
        }//exception
    }//method

}//class
