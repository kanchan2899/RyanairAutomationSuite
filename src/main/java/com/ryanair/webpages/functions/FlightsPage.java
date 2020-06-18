package com.ryanair.webpages.functions;

import com.ryanair.base.BaseClass;
import com.ryanair.utils.WebDriverUtility;
import com.ryanair.webpages.elements.FlightsPageElements;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage extends FlightsPageElements {

    private WebDriverUtility driverUtility;

    public FlightsPage(){
        PageFactory.initElements(BaseClass.driver, this);
        driverUtility = new WebDriverUtility(BaseClass.driver);
    }

    public String getOriginCountry(){
        return originCountry.getAttribute("innerHTML");
    }

    public String getDestinationCountry(){
        return destinationCountry.getAttribute("innerHTML");
    }

    public String getDepartureDate(){
        return departureDate.getText() + " " + departureMonth.getText();
    }

    public String getReturnDate(){
        return returnDate.getText() + " " + returnMonth.getText();
    }

    public void selectInboundRegularFlight() {
        BaseClass.driver.navigate().refresh();
        driverUtility.click(inboundFlight);
    }

    public void selectOutboundRegularFlight(){
        outboundFlight.click();
        outboundRegularFlight.click();
    }

}
