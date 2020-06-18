package com.ryanair.webpages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightsPageElements {

    @FindBy(xpath = "//div[contains(@class, 'details__header')]/h4[1]")
    public WebElement originCountry;

    @FindBy(xpath = "//div[contains(@class, 'details__header')]/h4[2]")
    public WebElement destinationCountry;

    @FindBy(xpath = "//journey-container[@outbound]//li[3]//div[contains(@class, 'date-item__date')]//span[1]")
    public WebElement departureDate;

    @FindBy(xpath = "//journey-container[@outbound]//li[3]//div[contains(@class, 'date-item__date')]//span[2]")
    public WebElement departureMonth;

    @FindBy(xpath = "//journey-container[@inbound]//li[3]//div[contains(@class, 'date-item__date')]//span[1]")
    public WebElement returnDate;

    @FindBy(xpath = "//journey-container[@inbound]//li[3]//div[contains(@class, 'date-item__date')]//span[2]")
    public WebElement returnMonth;

    //@FindBy(xpath = "//journey-container[@outbound]//div[@class='card-header b2']")
    //@FindBy(xpath = "//flight-list/div/flight-card/div/div/div[1]/div")
    @FindBy(xpath = "//journey-container[@outbound]//div[@class='card-info__cols-container']")
    public WebElement outboundFlight;

    @FindBy(xpath = "//journey-container[@outbound]//fare-table/div[@class='fare-card-container']/div[2]//button")
    public WebElement outboundRegularFlight;

    @FindBy(xpath = "//journey-container[@inbound]//flight-card/div//div[contains(@class, 'card-header')]")
    public WebElement inboundFlight;

    @FindBy(xpath = "//journey-container[@inbound]//div[@class='fare-card-container']/div[2]//button")
    public WebElement inboundRegularFlight;

}
