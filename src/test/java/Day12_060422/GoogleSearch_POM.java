package Day12_060422;

import PageObjects.BaseClass;
import ReusableClasses.Reusable_Annotations;
import org.testng.annotations.Test;

public class GoogleSearch_POM extends Reusable_Annotations {

    @Test
    public void SearchForAnyKeyword(){

        driver.navigate().to("https://www.google.com");
        BaseClass.googleHomePageStatic().enterUserValue("BMW");
        BaseClass.googleHomePageStatic().clickSearch();
        BaseClass.googleSearchResultPageStatic().getSearchResult();
        BaseClass.googleSearchResultPageStatic().getSearchResultandSplit();
    }//Test
}//class
