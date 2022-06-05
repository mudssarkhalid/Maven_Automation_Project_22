package PageObjects;

import ReusableClasses.POM_Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage extends Reusable_Annotations {
    ExtentTest logger;

    public GoogleSearchResultPage(WebDriver driver) {
        //page factory function for page object
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;

    }//constructor

    @FindBy(xpath = "//*[@id='result-stats']")
    WebElement searchResult;

    public void getSearchResult(){
        POM_Reusable_Actions_Loggers.getTextAction(driver, searchResult,logger,"Search Result");
    }//class

    public void getSearchResultandSplit(){
        String result = POM_Reusable_Actions_Loggers.getTextAction(driver, searchResult,logger,"Search Result");
        String[] arrayResult = result.split(" ");
        System.out.println("The number of results is " + arrayResult[1]);
        logger.log(LogStatus.INFO,"The number of results is " + arrayResult[1]);
    }
}//parent class
