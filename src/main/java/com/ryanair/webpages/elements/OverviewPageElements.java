package com.ryanair.webpages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPageElements {

    @FindBy(xpath = "//a[@data-ref='secondary-navigation-section-trip-overview']")
    public WebElement nav_overview;

    @FindBy(xpath = "//a[contains(text(), 'Flights')]")
    public WebElement nav_flights;

    @FindBy(xpath = "//a[@data-ref='secondary-navigation-section-getting-around']")
    public WebElement nav_car_hire;

    @FindBy(xpath = "//a[@data-ref='secondary-navigation-section-staying-there']")
    public WebElement nav_accommodation;

    @FindBy(xpath = "//a[@data-ref='secondary-navigation-section-things-to-do']")
    public WebElement nav_events_activities;

}
