package actionItems;

import PageObjects.BaseClass;
import PageObjects.UBSHomePage;
import ReusableClasses.POM_Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotations;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;

/*
- Choose 6-7 use cases from your current company to automate
- Using TestNG BeforeSuite, AfterSuite @Test(s) and ExtentTest logger in one java class and automate those use cases
- be sure to put proper comments on each steps of your test, so we know exactly what scenarios you are covering
- right on top of each @Test just briefly put comment on what use case you are covering, so we know what to look out for
- put dependsOnMethod if test are dependent on each other or put priorities on the ones that are not dependent on each other
- modify remaining reusable methods with ExtentTest loggers
- also in one of your @test scenario, I want you to verify the title of the page by putting log.pass and log.fail on your reusable verifyTitle method
- Take a screenshot of Extent HTML report or put as an attachment in the email
 */
public class actionItem_7_UBS_POM extends Reusable_Annotations {
    /*
        Use Case 1
        As a potential UBS client, I want to be able to view the different wealth management resources offered by UBS from the main page,
        so that I can learn more about the services
            * I should be able to click the wealth management dropdown
            * The dropdown should animate on open and close
            * The dropdown should list Homepage, Our Approach, Who We Serve, Specialized Advice, Insights
            * Each link should be clickable, and redirect the browser to the appropriate URL
    */

    @Test
    public void wealthManagementDropdowns() throws InterruptedException {

        //declare ArrayList for the unique xpaths of dropdown items
        ArrayList<String> item_xpath = new ArrayList<>();
        item_xpath.add("//*[text()='Homepage']");
        item_xpath.add("//*[text()='Our approach']");
        item_xpath.add("//*[text()='Who we serve']");
        item_xpath.add("//*[text()='Specialized advice']");
        item_xpath.add("//*[text()='Insights']");

        ArrayList<String> item_name = new ArrayList<>();
        item_name.add("Wealth Management Homepage");
        item_name.add("Wealth Management Our approach");
        item_name.add("Wealth Management Who we serve");
        item_name.add("Wealth Management Specialized advice");
        item_name.add("Wealth Management Insights");

        ArrayList<String> item_URL = new ArrayList<>();
        item_URL.add("https://www.ubs.com/us/en/wealth-management.html");
        item_URL.add("https://www.ubs.com/us/en/wealth-management/our-approach.html");
        item_URL.add("https://www.ubs.com/us/en/wealth-management/who-we-serve.html");
        item_URL.add("https://www.ubs.com/us/en/wealth-management/specialized-advice.html");
        item_URL.add("https://www.ubs.com/us/en/wealth-management/insights.html");

        ArrayList<String> item_URL_name = new ArrayList<>();
        item_URL_name.add("Wealth Management Homepage URL");
        item_URL_name.add("Wealth Management Our approach URL");
        item_URL_name.add("Wealth Management Who we serve URL");
        item_URL_name.add("Wealth Management Specialized advice URL");
        item_URL_name.add("Wealth Management Insights URL");

        for (int i = 0; i < item_xpath.size(); i++) {
            //navigate to UBS website
            driver.navigate().to("https://www.ubs.com/us/en.html");
            //declare explicit wait
            WebDriverWait wait = new WebDriverWait(driver,10);
            Thread.sleep(1000);
            //click on the Wealth Management tab
            BaseClass.ubsHomePage().clickOnWealthManagement();
            BaseClass.ubsHomePage().clickOnDropDownValue(item_xpath.get(i),item_name.get(i));
            Reusable_Actions_Loggers.verifyURLAction(driver,item_URL.get(i),logger,item_URL_name.get(i));
        }//loop
    }//wealthManagementDropdowns

        /*
        Use Case 2
        As a potential UBS client, I want to be able to load the wealth management page quickly,
        and be able to navigate it fluidly
            * The page should load within 3 seconds on a stable internet connection
            * The video header should load and start playing automatically
            * The video header should have a visible pause button on the top right
            * Clicking the pause button should pause the video and change the button to a play button
            * Clicking the play button should play the video and change the button to a pause button
     */

    @Test
    public void ExploreWebManagementPage() {
        //navigate to UBS Wealth Management Page
        driver.navigate().to("https://www.ubs.com/us/en/wealth-management.html");
        //declare explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);

        //measure and long how long it takes to load the page
        double loadingTime = Reusable_Actions_Loggers.pageLoadTime(driver,"https://www.ubs.com/us/en/wealth-management.html",logger);
        System.out.println("The page loaded in " + loadingTime + " seconds.");
        if (loadingTime>=3.0){
            System.out.println("The page took longer to load than the requirement of loading within 3 seconds");
        } else {
            System.out.println("The page loaded within the requirement limit of 3 seconds");
        }//conditional

        //confirm the video header is visible
        BaseClass.ubsWealthManagementPage().headerVisible();

        //confirm the pause button for the video header is visible
        BaseClass.ubsWealthManagementPage().pauseButtonVisible();

        //click the pause button for the video header
        BaseClass.ubsWealthManagementPage().clickOnPauseButton();

        //confirm the pause button changes to play button on click
        BaseClass.ubsWealthManagementPage().playButtonVisible();

        //click the play button for the video header
        BaseClass.ubsWealthManagementPage().clickOnPlayButton();

        //confirm the pause button changes to pause button on click
        BaseClass.ubsWealthManagementPage().pauseButtonVisible();

    }//ExploreWebManagementPage

    /*
        Use Case 3
        As a UBS client, I want to be able to easily find where to log in, so that I can access my account
            * I should see a red button on the top right labeled UBS logins, with an arrow pointing down
            * When the logins button is clicked, I should see a drop-down list of available logins
     */
    @Test
    public void logIn() throws InterruptedException {
        //navigate to UBS Wealth Management Page
        driver.navigate().to("https://www.ubs.com/us/en/wealth-management.html");
        //declare explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);

        //confirm UBS Logins button is visible
        BaseClass.ubsWealthManagementPage().loginsButtonVisible();
        //click on Logins Button
        BaseClass.ubsWealthManagementPage().clickOnLogins();
        Thread.sleep(500);
        //confirm the Logins drop down is visible
        BaseClass.ubsWealthManagementPage().dropDownVisible();
    }//logIns

    /*
        Use Case 4
        As a potential UBS client I want to be able to easily initiate contact with UBS,
        so that I can take advantage of offered services
            * I should see a contact tab on the right of the header
            * When clicked the contact dropdown list should animate open and close
            * The dropdown should list Get In Touch, Find Your UBS Financial Advisor, Make An Appointment, Relationship Summary
     */

    @Test
    public void initiateContact() throws InterruptedException {
        //navigate to the UBS website
        driver.navigate().to("https://www.ubs.com/us/en/wealth-management.html");
        //confirm Contact button is visible
        BaseClass.ubsWealthManagementPage().contactVisible();
        //click on the Contact button
        BaseClass.ubsWealthManagementPage().clickOnContact();
        Thread.sleep(500);
        //confirm the contact drop-down is visible
        BaseClass.ubsWealthManagementPage().contactDropDownVisible();

        // confirm visibility of drop-down elements by iterating through an array
        //declare ArrayList for the unique xpaths of dropdown items
        ArrayList<String> item_xpath = new ArrayList<>();
        item_xpath.add("//*[text()='Get in touch']");
        item_xpath.add("//*[text()='Find your UBS Financial Advisor']");
        item_xpath.add("//*[text()='Make an appointment']");
        item_xpath.add("//*[text()='Relationship summary']");

        ArrayList<String> item_name = new ArrayList<>();
        item_name.add("Contact - Get in touch");
        item_name.add("Contact - Find your UBS Financial Advisor");
        item_name.add("Contact - Make an appointment");
        item_name.add("Contact - Relationship summary");

        for (int i = 0; i<item_xpath.size();i++){
            BaseClass.ubsWealthManagementPage().visibilityOfContactOptions(item_xpath.get(i),item_name.get(i));
        }//loop
    }//initiateContact



    /*
        Use Case 5
        As a potential UBS client I want to be able to submit my contact information on the Get In Touch page, so that I can be contacted by a UBS representative
             * There should be a form of fields fillable by the visitor including, first name, last name, city, state, zip, phone, email, preferred method of contact, how much you???re interested in investing, how can a UBS advisor help you?
             * There should be a legal note drop-down which lists UBS legal note
             * The terms of use should be linked below the form, as well as the privacy statement
             * There should be a required confirmation box, acknowledging the user accepts all terms
             * If a field is not filled, the field should highlight yellow with a message below it stating please fill it out
             * If all fields are filled correctly, clicking the blue submit button at the bottom should submit the form
     */
    @Test
    public void getInTouch() {
        //navigate to the UBS website
        driver.navigate().to("https://www.ubs.com/us/en/wealth-management/contact-us/get-in-touch.html");
        //declare ArrayLists for the unique xpaths of dropdown items
        ArrayList<String> item_xpath = new ArrayList<>();
        item_xpath.add("//*[@id='first-name']");
        item_xpath.add("//*[@id='last-name']");
        item_xpath.add("//*[@id='city']");
        item_xpath.add("//*[@id='phone']");
        item_xpath.add("//*[@id='email']");
        item_xpath.add("//*[@class='basecomponent radio radio__base']");
        item_xpath.add("//*[@id='How_much_are_you_interested_in_investing']");
        item_xpath.add("//*[@id='Advisorhelp']");

        ArrayList<String> item_name = new ArrayList<>();
        item_name.add("First name field");
        item_name.add("Last name field");
        item_name.add("City field");
        item_name.add("State field");
        item_name.add("Zip field");
        item_name.add("Phone field");
        item_name.add("E-mail field");
        item_name.add("Preferred method of contact radio buttons");
        item_name.add("How much are you interested in investing dropdown");
        item_name.add("How can UBS help? field");

        //iterate through drop-down elements
        for (int i=0; i<item_xpath.size();i++) {
            //verify all drop-down items are visible
            BaseClass.ubsWealthManagementPage().visibilityOfContactFields(item_xpath.get(i), item_name.get(i));
        }//loop
        //verify visibility of Legal note drop-down arrow
        Reusable_Actions_Loggers.visibilityOfElement(driver, "//*[@accordion__arrowIcon']", logger, "Legal note dropdown");
    }
}//parent class
