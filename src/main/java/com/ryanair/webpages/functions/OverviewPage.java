package com.ryanair.webpages.functions;

import com.ryanair.base.BaseClass;
import com.ryanair.utils.WebDriverUtility;
import com.ryanair.webpages.elements.OverviewPageElements;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;

/**
 * This page contains the methods and operations that can be performed on the webelements of flights page.
 */
public class OverviewPage extends OverviewPageElements {

    private WebDriverUtility driverUtility;

    // Constructor to initialize the elements on the flights page
    public OverviewPage(){
        PageFactory.initElements(BaseClass.driver, this);
        driverUtility = new WebDriverUtility(BaseClass.driver);
    }

    // Method to get the overview page title
    public String getPageTitle(){
        return driverUtility.getPageTitle();
    }

    // Method to check if the page is loaded
    public boolean checkIfPageIsLoaded(){
        return driverUtility.checkIfPageIsLoaded();
    }

    // Method to select the flight page
    public FlightsPage selectFlightsPage(){
        try {
            driverUtility.click(nav_flights);
            return new FlightsPage();
        } catch (StaleElementReferenceException e){
            if(nav_flights.isDisplayed()){
                driverUtility.click(nav_flights);
                return new FlightsPage();
            }
        }
        return null;
    }

}
