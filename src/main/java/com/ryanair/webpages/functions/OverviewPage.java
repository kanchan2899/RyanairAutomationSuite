package com.ryanair.webpages.functions;

import com.ryanair.base.BaseClass;
import com.ryanair.utils.WebDriverUtility;
import com.ryanair.webpages.elements.OverviewPageElements;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends OverviewPageElements {

    private WebDriverUtility driverUtility;

    public OverviewPage(){
        PageFactory.initElements(BaseClass.driver, this);
        driverUtility = new WebDriverUtility(BaseClass.driver);
    }

    public String getPageTitle(){
        return driverUtility.getPageTitle();
    }

    public boolean checkIfPageIsLoaded(){
        return driverUtility.checkIfPageIsLoaded();
    }

    public FlightsPage selectFlightsPage(){
        try {
            driverUtility.click(nav_flights);
        } catch (StaleElementReferenceException e){
            if(nav_flights.isDisplayed()){
                driverUtility.click(nav_flights);
            }
        }
        return new FlightsPage();
    }

}
