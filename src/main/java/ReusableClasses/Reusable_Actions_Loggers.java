package ReusableClasses;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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

public class Reusable_Actions_Loggers {

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
        //options.addArguments("headless");
        //define the web driver I am going to use
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }//method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"Successfully hovered on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Failed ot hover on element " + elementName + " " + e);
        }//exception
    }//method

    //create a click method
    public static void clickAction(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Failed to click on element " + elementName + " " + e);
        }//exception
    }//method

    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submitted on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Failed to submit on element " + elementName + " " + e);
        }
    }//end of submit

    //create a send keys method
    public static void sendKeysAction(WebDriver driver,String xpath, String userValue, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully entered user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter userValue on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Failed to enter userValue on element " + elementName + " " + e);
        }//exception
    }//method

    //create a get text method
    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully captured text of " + elementName);
            logger.log(LogStatus.INFO,"The captured text of " + elementName + " is " + result);
        } catch (Exception e) {
            System.out.println("Unable to get text " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Failed to get text of element " + elementName + " " + e);
        }//exception
        return result;
    }//method


    //create a click by index method
    public static void clickByIndexAction(WebDriver driver,String xpath, int indexNumber,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS,"Successfully clicked on element by index " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Failed to click on element by index " + elementName + " " + e);
        }//exception
    }//end of clickByIndexAction

    //create a switch to tab by index method
    public static void switchToTabByIndex(WebDriver driver, int indexNumber,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(indexNumber));
            logger.log(LogStatus.PASS,"Successfully switched to tab by index " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to switch to tab by index " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Failed to switch to tab by index " + elementName + " " + e);
        }//exception
    }//end of switchToTabByIndex


    //create a verifyTitle method
    public static String verifyTitleAction(WebDriver driver, String contains,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String actualTitle = driver.getTitle();
        try {
            if (actualTitle.contains(contains)){
                System.out.println("The web page title contains " + contains);
                logger.log(LogStatus.PASS,"Successfully verified the web page title contains " + contains);
            }else {
                System.out.println("The web page title does not contain " + contains + ". The actual title is " + actualTitle);
                logger.log(LogStatus.FAIL,"Successfully verified the title does not contain " + contains);
                logger.log(LogStatus.INFO,"The actual web page title is " + actualTitle);
            }//conditional
        } catch (Exception e) {
            System.out.println("Unable to get text " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Failed to verify title text " + elementName + " " + e);
        }//exception
        return actualTitle;
    }//method

    //create a verifyURL method
    public static void verifyURLAction(WebDriver driver, String URL, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String actualURL = driver.getCurrentUrl();
        try {
            if (actualURL.matches(URL)){
                System.out.println("The web page URL is verified to be " + URL);
                logger.log(LogStatus.PASS,"Successfully verified the web page URL is " + URL);
            }else {
                System.out.println("The web page URL does not match " + URL + ". The actual URL is " + actualURL);
                logger.log(LogStatus.FAIL,"Failed to verify the URL matches " + URL);
                logger.log(LogStatus.INFO,"The actual web page URL is " + actualURL);
            }//conditional
        } catch (Exception e) {
            System.out.println("Unable to verify URL " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Failed to verify URL " + elementName + " " + e);
        }//exception
    }//method

    //create a selectByText method
    public static void selectByText(WebDriver driver,String xpath, String contains,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select elements = new Select(driver.findElement(By.xpath(xpath)));
            element.click();
            elements.selectByVisibleText(contains);
            logger.log(LogStatus.PASS,"Successfully selected by text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select by " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Failed to select by text " + elementName + " " + e);
        }//exception
    }//method
    //create a scrollToAction method
    public static void scrollToAction(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare javascriptexecutor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //scroll to element
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.log(LogStatus.PASS,"Successfully scrolled " + elementName + " into view");
        } catch (Exception e) {
            System.out.println("Unable to scroll to element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Failed to scroll " + elementName + " into view " + e);
        }//exception
    }//method

    public static double pageLoadTime(WebDriver driver,String URL,ExtentTest logger){
        //get the current system time in ms
        double start = System.currentTimeMillis();
        //load the URL
        driver.get(URL);
        //get the time the page finished loading
        double finish = System.currentTimeMillis();
        //subtract finish time from start time
        double totalTime = finish - start;
        //convert ms to s
        double timeToSeconds = totalTime / 1000;
        logger.log(LogStatus.INFO,"Page load time measured successfully as " + timeToSeconds + " seconds.");
        return timeToSeconds;
    }//method

    public static void visibilityOfElement(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        boolean elementState = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed();
        try {
            if (elementState == true){
                System.out.println("The " + elementName + " is visible.");
                logger.log(LogStatus.PASS,elementName + " is visible.");
            }else {
                System.out.println("The " + elementName + " is not visible.");
                //logger.log(LogStatus.FAIL,elementName + " is not visible.");
            }//conditional
        } catch (Exception e){
            logger.log(LogStatus.FAIL,"Failed to verify visibility of " + elementName + e);
        }//exception
    }//method

    public static void presenceOfElement(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isDisplayed();
        try {
            if (elementState == true){
                System.out.println("The " + elementName + " is visible.");
                logger.log(LogStatus.PASS,elementName + " is visible.");
            }else {
                System.out.println("The " + elementName + " is not visible.");
                //logger.log(LogStatus.FAIL,elementName + " is not visible.");
            }//conditional
        } catch (Exception e){
            logger.log(LogStatus.FAIL,"Failed to verify visibility of " + elementName + e);
        }//exception
    }//method

}//class
