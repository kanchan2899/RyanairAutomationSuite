package com.ryanair.webpages.functions;

import com.ryanair.base.BaseClass;
import com.ryanair.utils.WebDriverUtility;
import com.ryanair.webpages.elements.FlightsPageElements;
import org.openqa.selenium.support.PageFactory;

/**
 * This page contains the methods and operations that can be performed on the webelements of flights page.
 */
public class FlightsPage extends FlightsPageElements {

    private WebDriverUtility driverUtility;

    // Constructor to initialize the elements on the flights page
    public FlightsPage(){
        PageFactory.initElements(BaseClass.driver, this);
        driverUtility = new WebDriverUtility(BaseClass.driver);
    }

    // Method to get the origin country
    public String getOriginCountry(){
        return originCountry.getAttribute("innerHTML");
    }

    // Method to get the destination country
    public String getDestinationCountry(){
        return destinationCountry.getAttribute("innerHTML");
    }

    // Method to get the departure date
    public String getDepartureDate(){
        return departureDate.getText() + " " + departureMonth.getText();
    }

    // Method to get the return date
    public String getReturnDate(){
        return returnDate.getText() + " " + returnMonth.getText();
    }

    // Method to select the inbound regular flight
    public void selectInboundRegularFlight() {
        BaseClass.driver.navigate().refresh();
        driverUtility.click(inboundFlight);
    }

    // Method to select the outbound regular flight
    public void selectOutboundRegularFlight(){
        driverUtility.click(outboundFlight);
        driverUtility.click(outboundRegularFlight);
    }

}
