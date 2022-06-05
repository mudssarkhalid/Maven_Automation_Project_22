package actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class inClass_actionItem {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("New York");
        destinations.add("Boston");
        destinations.add("Chicago");

        ArrayList<String> checkIn = new ArrayList<>();
        checkIn.add("5");
        checkIn.add("6");
        checkIn.add("7");

        ArrayList<String> checkOut = new ArrayList<>();
        checkOut.add("15");
        checkOut.add("16");
        checkOut.add("17");

        ArrayList<Integer> adultGroupOne = new ArrayList<>();
        adultGroupOne.add(3);
        adultGroupOne.add(4);
        adultGroupOne.add(5);

        ArrayList<Integer> rooms = new ArrayList<>();
        rooms.add(2);
        rooms.add(3);
        rooms.add(4);

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        //options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the web driver I am going to use
        WebDriver driver = new ChromeDriver(options);

        for (int i = 0; i < 1; i++) {
        driver.navigate().to("https://www.hotels.com/");
        Thread.sleep(2000);

        //exception for clicking the search box
        try{
            WebElement destinationSearch = driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']"));
            destinationSearch.click();

        }
        catch (Exception e){
            System.out.println("Unable to find the Destination search field, " + e);
        }

        Thread.sleep(3000);

        //exception for selecting the search field and entering the destinations
        try{
            WebElement whereareyougoing = driver.findElement(By.xpath("//*[@id='location-field-destination']"));
            whereareyougoing.click();
            whereareyougoing.sendKeys(destinations.get(i));
            Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println("Unable to click the first result, " + e);
        }

        //exception for clicking the first suggestion
        try{
            WebElement firstResult = driver.findElements(By.xpath("//*[@data-stid='location-field-destination-result-item-button']")).get(0);
            firstResult.click();
            Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println("Unable to find the first search result, " + e);
        }

        //exception for entering the check in date
        try{
            WebElement checkInBox = driver.findElement(By.xpath("//*[@data-name='d1']"));
            checkInBox.click();
            Thread.sleep(1000);
            WebElement checkInCalendar = driver.findElements(By.xpath("//*[@data-day='"+checkIn.get(i)+"']")).get(0);
            checkInCalendar.click();
            Thread.sleep(1000);
            WebElement doneButton = driver.findElement(By.xpath("//*[@data-stid='apply-date-picker']"));
            doneButton.click();
            Thread.sleep(1000);

        }
        catch (Exception e){
            System.out.println("Unable to enter the check in date, " + e);
        }

        //exception for entering the check out date
        try{
                WebElement checkOutBox = driver.findElement(By.xpath("//*[@data-name='d2']"));
                checkOutBox.click();
                Thread.sleep(1000);
                WebElement checkOutCalendar = driver.findElements(By.xpath("//*[@data-day='"+checkOut.get(i)+"']")).get(1);
                checkOutCalendar.click();
                Thread.sleep(1000);
                WebElement doneButton = driver.findElement(By.xpath("//*[@data-stid='apply-date-picker']"));
                doneButton.click();
                Thread.sleep(1000);
        }
        catch (Exception e){
                System.out.println("Unable to enter the check out date, " + e);
        }

        //exception for clicking the travelers box
        try{
                WebElement travelersBox = driver.findElement(By.xpath("//*[@data-testid='travelers-field-trigger']"));
                travelersBox.click();
                Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println("Unable to find the travelers box, " + e);
        }

        //exception for entering the number of adults
        try {
            if (rooms.get(i) == 1){

                WebElement roomOneAdults = driver.findElement(By.xpath("//*[@id='adult-input-0']"));
                int roomOneAdultsInt = Integer.parseInt(roomOneAdults.getText());

                if (adultGroupOne.get(i) < roomOneAdultsInt) {
                    WebElement decreaseRoomOneAdults = driver.findElement(By.xpath("//*[@aria-label='Decrease adults in room 1']"));
                    decreaseRoomOneAdults.click();
                }//if
                else {
                    for (int a = 2; a < adultGroupOne.get(i); a++) {
                        WebElement increaseRoomOneAdults = driver.findElement(By.xpath("//*[@aria-label='Increase adults in room 1']"));
                        increaseRoomOneAdults.click();
                    }//for
                }//else
            }//if
            }//exception

        catch(Exception e){
                System.out.println("Unable to enter the number of adults, " + e);
            }//catch



        }//loop
    }//main
}//class
