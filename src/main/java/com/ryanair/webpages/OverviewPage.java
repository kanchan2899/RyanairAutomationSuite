package com.ryanair.webpages;

import com.ryanair.base.BaseClass;
import com.ryanair.utils.WebDriverUtility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends BaseClass {

    private WebDriverUtility driverUtility;

    @FindBy(xpath = "//a[@data-ref='secondary-navigation-section-trip-overview']")
    WebElement nav_overview;

    @FindBy(xpath = "//a[contains(text(), 'Flights')]")
    WebElement nav_flights;

    @FindBy(xpath = "//a[@data-ref='secondary-navigation-section-getting-around']")
    WebElement nav_car_hire;

    @FindBy(xpath = "//a[@data-ref='secondary-navigation-section-staying-there']")
    WebElement nav_accommodation;

    @FindBy(xpath = "//a[@data-ref='secondary-navigation-section-things-to-do']")
    WebElement nav_events_activities;

    public OverviewPage(){
        PageFactory.initElements(driver, this);
        driverUtility = new WebDriverUtility(driver);
    }

    public String getPageTitle(){
        return driverUtility.getPageTitle();
    }

    public boolean checkIfPageIsLoaded(){
        return driverUtility.checkIfPageIsLoaded();
    }

    public FlightsPage selectFlightsPage(){
        try {
            nav_flights.click();
        } catch (StaleElementReferenceException e){
            if(nav_flights.isDisplayed()){
                nav_flights.click();
            }
        }
        return new FlightsPage();
    }

}
