package actionItems;
/*
Action Item
I want you guys to automate UHC.com
Use the reusable methods that I created in class.
I want you to create three reusable methods of your own and add it to your Reusable Actions class that I have created in class
Create reusable methods for selectByText, switchToTabBylndex and verifyTitle
Create the following ArrayList and iterate at least 3 times for 3 different values
firstName, lastName, birthMonth, birthday, birthYear, zipCode, memberld
Test Steps:
Navigate to UHC.com
Verify the home page tile contains Health insurance plans
**This is where you will call the verifyTitle method. For verify title don't need try catch
Click on 'Find a Doctor' link
Click on Sign in
Click on Medicare Plan?
New tab opens so you need to switch to the new tab by calling arraylist from reusable action to your test class **this is where you will call
switchToTabByindex method.. Don't need try catch for this one either
Click on Register Now
Enter first name //this is where you pass the firstName.get(i)
Enter last name //this where you pass the lastName.get(i)
Select birth month **this is where you will call your selectByText method to select the dropdown and pass it from arrayList
Enter birthDay //this is where you pass the get(i) for birth day arraylist
Enter birth year //this is where you pass the get(i) for birth year arraylist
Enter zipCode //this is where you enter zipCode.get(i)
Enter memberld //this is where vou pass invalid member id by .get(i) from your member id arrayList
Click on 'Continue' button
I want you to capture the following error by calling your reusable method for captureText
Store that reusable method on a String variable on your psvm class and print out that variable for the error message below
close the driver
Switch back to default tab b index o
 */

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class actionItem_5 {
    public static void main(String[] args) {

        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Fari");
        firstName.add("Billy");
        firstName.add("Rick");

        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Khan");
        lastName.add("Bob");
        lastName.add("Randal");

        ArrayList<String> birthMonth = new ArrayList<>();
        birthMonth.add("April");
        birthMonth.add("January");
        birthMonth.add("June");

        ArrayList<String> birthDay = new ArrayList<>();
        birthDay.add("18");
        birthDay.add("21");
        birthDay.add("23");

        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("1998");
        birthYear.add("1996");
        birthYear.add("1990");

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11360");
        zipCode.add("11003");
        zipCode.add("11010");

        ArrayList<String> memberID = new ArrayList<>();
        memberID.add("0123456789");
        memberID.add("9876543210");
        memberID.add("8773934448");

        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        for (int i = 0; i < firstName.size(); i++) {

            //navigate to UHC.com
            driver.navigate().to("https://www.uhc.com");

            //verify the home page title contains Health Insurance plans
            String actualTitle = Reusable_Actions.verifyTitleAction(driver, "Health insurance plans", "Home Page Title");

            //click on Find a doctor
            Reusable_Actions.clickAction(driver, "//*[@href='/find-a-doctor']", "Find a doctor");

            //click on Sign in
            Reusable_Actions.clickAction(driver, "//*[@aria-label='Sign in menu']", "Sign In");

            //click on Medicare plan?
            Reusable_Actions.clickAction(driver, "//*[@href='https://www.medicare.uhc.com/?aud=uhc-medicare']", "Medicare plan");

            //switch to new tab
            Reusable_Actions.switchToTabByIndex(driver, 1, "New tab");

            //click on Register Now
            Reusable_Actions.clickAction(driver, "//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']", "Register Now");

            //enter first name
            Reusable_Actions.sendKeysAction(driver, "//*[@id='firstName']", firstName.get(i), "First name field");

            //enter last name
            Reusable_Actions.sendKeysAction(driver, "//*[@id='lastName']", lastName.get(i), "First name field");

            //select birth month
            Reusable_Actions.selectByText(driver,"//*[@id='dob_month_input']", birthMonth.get(i),"Birth month field");

            //enter birthday
            Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_day']", birthDay.get(i), "Birth day field");

            //enter birth year
            Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_year']", birthYear.get(i), "Birth year field");

            //enter zip code
            Reusable_Actions.sendKeysAction(driver, "//*[@id='zipCode']", zipCode.get(i), "Zip code field");

            //enter Member ID
            Reusable_Actions.sendKeysAction(driver, "//*[@id='memberId']", memberID.get(i), "Member ID field");

            //click on Continue
            Reusable_Actions.clickAction(driver, "//*[@id='submitBtn']", "Continue button");

            //capture the error code
            String error = Reusable_Actions.getTextAction(driver, "//*[@class='SummaryError_ErrorContent__1j0LP']","Error code");
            System.out.println("The error code is " + error);

            //close the second tab
            driver.close();

            //switch to original tab
            Reusable_Actions.switchToTabByIndex(driver, 0, "New tab");
        }//for
        driver.quit();
    }//method
}//class
