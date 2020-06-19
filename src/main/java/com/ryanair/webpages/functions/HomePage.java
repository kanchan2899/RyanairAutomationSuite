package com.ryanair.webpages.functions;

import com.ryanair.base.BaseClass;
import com.ryanair.testdata.JSONReader;
import com.ryanair.utils.WebDriverUtility;
import com.ryanair.webpages.elements.HomePageElements;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

/**
 * This page contains the methods and operations that can be performed on the webelements of flights page.
 */
public class HomePage extends HomePageElements {

    static final Logger logger = LogManager.getLogger(HomePage.class.getName());
    private JSONReader jsonReader;
    private WebDriverUtility driverUtility;
    public String origin_country_name;
    public String destination_country_name;

    // Constructor to initialize the elements on the flights page.
    public HomePage(){
        PageFactory.initElements(BaseClass.driver, this);
        driverUtility = new WebDriverUtility(BaseClass.driver);
        jsonReader = new JSONReader();
        origin_country_name = jsonReader.readValue("origin_country");
        destination_country_name = jsonReader.readValue("destination_country");

    }

    public String getPageTitle(){
        logger.info("Getting page title");
        return driverUtility.getPageTitle();
    }

    public boolean checkIfPageIsLoaded(){
        return driverUtility.checkIfPageIsLoaded();
    }

    public String getDepartureDate(){
        return departure_date_value.getText();
    }

    public void selectCountries(){
        driverUtility.click(cookie_popup);
        driverUtility.click(flights_tab);
        driverUtility.clearField(origin_country);
        driverUtility.type(origin_country, origin_country_name);
        driverUtility.clearField(destination_country);
        driverUtility.type(destination_country, destination_country_name);
        driverUtility.click(destination_airport);
    }

    public void selectDates() {
        departure_date.click();
        return_date.click();
    }

    public void selectPassengers(){
        number_of_adults.click();
        number_of_children.click();
        passengers_done_button.click();
    }

    public OverviewPage clickSearchButton(){
        search_button.click();
        return new OverviewPage();
    }
}
