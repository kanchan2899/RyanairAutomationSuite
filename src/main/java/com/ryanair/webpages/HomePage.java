package com.ryanair.webpages;

import com.ryanair.base.BaseClass;
import com.ryanair.testdata.JSONReader;
import com.ryanair.utils.WebDriverUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    private JSONReader jsonReader;
    private WebDriverUtility driverUtility;

    @FindBy(xpath = "//button[contains(@data-ref, 'search-widget-tabs__flights')]")
    WebElement flights_tab;

    @FindBy(id = "input-button__departure")
    WebElement origin_country;

    @FindBy(id = "input-button__destination")
    WebElement destination_country;

    @FindBy(xpath = "//hp-airports-list/div[2]/div/hp-airport-item")
    WebElement destination_airport;

    @FindBy(xpath = "//ry-tooltip//div[contains(@data-id, '2020-07-07')]")
    WebElement departure_date;

    @FindBy(xpath = "//div[@data-ref='input-button__dates-from']/div[2]")
    WebElement departure_date_value;

    @FindBy(xpath = "//div[contains(@data-id, '2020-07-14')]")
    WebElement return_date;

    @FindBy(xpath = "//ry-counter[@data-ref = 'passengers-picker__adults']/div[@class='counter']/div[3]")
    WebElement number_of_adults;

    @FindBy(xpath = "//ry-counter[@data-ref = 'passengers-picker__teens']/div[@class='counter']/div[3]")
    WebElement number_of_teens;

    @FindBy(xpath = "//ry-counter[@data-ref = 'passengers-picker__children']/div[@class='counter']/div[3]")
    WebElement number_of_children;

    @FindBy(xpath = "//ry-counter[@data-ref = 'passengers-picker__infant']/div[@class='counter']/div[3]")
    WebElement number_of_infants;

    @FindBy(xpath = "//button[contains(@class, 'passengers__confirm-button')]")
    WebElement passengers_done_button;

    @FindBy(xpath ="//button[contains(@class, 'flight-search-widget__start-search')]")
    WebElement search_button;

    public HomePage(){
        PageFactory.initElements(driver, this);
        driverUtility = new WebDriverUtility(driver);
        jsonReader = new JSONReader();

    }

    public String getPageTitle(){
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
}
