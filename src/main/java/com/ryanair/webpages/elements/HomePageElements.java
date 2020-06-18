package com.ryanair.webpages.elements;

import com.ryanair.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElements {

    @FindBy(xpath = "//button[contains(@data-ref, 'search-widget-tabs__flights')]")
    public WebElement flights_tab;

    @FindBy(id = "input-button__departure")
    public WebElement origin_country;

    @FindBy(id = "input-button__destination")
    public WebElement destination_country;

    @FindBy(xpath = "//hp-airports-list/div[2]/div/hp-airport-item")
    public WebElement destination_airport;

    @FindBy(xpath = "//ry-tooltip//div[contains(@data-id, '2020-07-07')]")
    public WebElement departure_date;

    @FindBy(xpath = "//div[@data-ref='input-button__dates-from']/div[2]")
    public WebElement departure_date_value;

    @FindBy(xpath = "//div[contains(@data-id, '2020-07-14')]")
    public WebElement return_date;

    @FindBy(xpath = "//ry-counter[@data-ref = 'passengers-picker__adults']/div[@class='counter']/div[3]")
    public WebElement number_of_adults;

    @FindBy(xpath = "//ry-counter[@data-ref = 'passengers-picker__teens']/div[@class='counter']/div[3]")
    public WebElement number_of_teens;

    @FindBy(xpath = "//ry-counter[@data-ref = 'passengers-picker__children']/div[@class='counter']/div[3]")
    public WebElement number_of_children;

    @FindBy(xpath = "//ry-counter[@data-ref = 'passengers-picker__infant']/div[@class='counter']/div[3]")
    public WebElement number_of_infants;

    @FindBy(xpath = "//button[contains(@class, 'passengers__confirm-button')]")
    public WebElement passengers_done_button;

    @FindBy(xpath ="//button[contains(@class, 'flight-search-widget__start-search')]")
    public WebElement search_button;


}
