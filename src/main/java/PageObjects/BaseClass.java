package PageObjects;

import ReusableClasses.Reusable_Annotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass extends Reusable_Annotations {
    public BaseClass(WebDriver driver){
        PageFactory.initElements(driver,this);
    }//end of constructor class

    //create static reference for google home page
    public static GoogleHomePage googleHomePageStatic(){
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        return  googleHomePage;
    }//end of googleHomePage method

    //create static reference for google search result page
    public static GoogleSearchResultPage googleSearchResultPageStatic(){
        GoogleSearchResultPage googleSearchResultPageStatic = new GoogleSearchResultPage(driver);
        return  googleSearchResultPageStatic;
    }//end of googleSearchResultPage method

}//parent class
