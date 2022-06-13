package Day12_060422;

import PageObjects.BaseClass;
import ReusableClasses.Reusable_Annotations;
import org.testng.annotations.Test;

public class GoogleSearch_POM extends Reusable_Annotations {

    @Test
    public void SearchForAnyKeyword(){

        driver.navigate().to("https://www.google.com");
        BaseClass.googleHomePage().enterUserValue("BMW");
        BaseClass.googleHomePage().clickSearch();
        BaseClass.googleSearchResultPage().getSearchResult();
        BaseClass.googleSearchResultPage().getSearchResultandSplit();
    }//Test
}//class
