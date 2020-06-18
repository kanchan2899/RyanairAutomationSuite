package com.ryanair.webpages;

import com.ryanair.base.BaseClass;
import com.ryanair.utils.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class FlightsPage extends BaseClass {

    private WebDriverUtility driverUtility;

    @FindBy(xpath = "//div[contains(@class, 'details__header')]/h4[1]")
    WebElement originCountry;

    @FindBy(xpath = "//div[contains(@class, 'details__header')]/h4[2]")
    WebElement destinationCountry;

    @FindBy(xpath = "//journey-container[@outbound]//li[3]//div[contains(@class, 'date-item__date')]//span[1]")
    WebElement departureDate;

    @FindBy(xpath = "//journey-container[@outbound]//li[3]//div[contains(@class, 'date-item__date')]//span[2]")
    WebElement departureMonth;

    @FindBy(xpath = "//journey-container[@inbound]//li[3]//div[contains(@class, 'date-item__date')]//span[1]")
    WebElement returnDate;

    @FindBy(xpath = "//journey-container[@inbound]//li[3]//div[contains(@class, 'date-item__date')]//span[2]")
    WebElement returnMonth;

    //@FindBy(xpath = "//journey-container[@outbound]//div[@class='card-header b2']")
    //@FindBy(xpath = "//flight-list/div/flight-card/div/div/div[1]/div")
    @FindBy(xpath = "//journey-container[@outbound]//div[@class='card-info__cols-container']")
    WebElement outboundFlight;

    @FindBy(xpath = "//journey-container[@outbound]//fare-table/div[@class='fare-card-container']/div[2]//button")
    WebElement outboundRegularFlight;

    @FindBy(xpath = "//journey-container[@inbound]//flight-card/div//div[contains(@class, 'card-header')]")
    WebElement inboundFlight;

    @FindBy(xpath = "//journey-container[@inbound]//div[@class='fare-card-container']/div[2]//button")
    WebElement inboundRegularFlight;

    public FlightsPage(){
        PageFactory.initElements(driver, this);
        driverUtility = new WebDriverUtility(driver);
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

    public void selectInboundRegularFlight() throws InterruptedException {

        driver.findElement(By.xpath("//div[@class='cookie-popup__close']")).click();
        driver.navigate().refresh();
        driverUtility.clickOnElementUsingJS(inboundFlight);
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
//        webDriverWait.until(ExpectedConditions.visibilityOf(inboundFlight));
//        try{
//            driverUtility.clickOnElement(inboundFlight);
//        } catch (Exception e){
//            System.out.println("In catch");
//            driverUtility.clickOnElementUsingJS(inboundFlight);
//        }
    }

    public void selectOutboundRegularFlight(){
        outboundFlight.click();
        outboundRegularFlight.click();
    }

}
