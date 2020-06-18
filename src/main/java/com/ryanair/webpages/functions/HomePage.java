package com.ryanair.webpages.functions;

import com.ryanair.base.BaseClass;
import com.ryanair.testdata.JSONReader;
import com.ryanair.utils.WebDriverUtility;
import com.ryanair.webpages.elements.HomePageElements;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends HomePageElements {

    static final Logger logger = LogManager.getLogger(HomePage.class.getName());
    private JSONReader jsonReader;
    private WebDriverUtility driverUtility;

    public HomePage(){
        PageFactory.initElements(BaseClass.driver, this);
        driverUtility = new WebDriverUtility(BaseClass.driver);
        jsonReader = new JSONReader();

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
        flights_tab.click();
        origin_country.clear();
        origin_country.sendKeys(jsonReader.readValue("origin_country"));
        destination_country.clear();
        destination_country.sendKeys(jsonReader.readValue("destination_country"));
        destination_airport.click();
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

    public void closeCookiePopup() {

    }
}