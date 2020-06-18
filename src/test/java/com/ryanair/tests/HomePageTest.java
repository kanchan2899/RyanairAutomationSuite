package com.ryanair.tests;

import com.ryanair.base.BaseClass;
import com.ryanair.webpages.functions.FlightsPage;
import com.ryanair.webpages.functions.HomePage;
import com.ryanair.webpages.functions.OverviewPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends BaseClass{

    private HomePage homePage;
    private OverviewPage overviewPage;
    private FlightsPage flightsPage;
    private BaseClass baseClass;
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        initialisation();
        homePage = new HomePage();
    }

    @Test (priority = 1)
    public void validateHomePageIsLoaded() {
        boolean isPageLoaded = homePage.checkIfPageIsLoaded();
        Assert.assertEquals(isPageLoaded, true, "Home Page is completely loaded");
    }

    @Test (priority = 2)
    public void validatePageTitle(){
        String pageTitle = homePage.getPageTitle();
        Assert.assertEquals(pageTitle, "Official Ryanair website | Cheap flights from Ireland | Ryanair");
    }

    @Test (priority = 3)
    public void searchFlights(){
        //homePage.closeCookiePopup();
        homePage.selectCountries();
        homePage.selectDates();
        homePage.selectPassengers();
        overviewPage = homePage.clickSearchButton();
    }

    @Test(priority = 4)
    public void navigateToFlights() throws InterruptedException {
        boolean isOverviewPageLoaded = overviewPage.checkIfPageIsLoaded();
        if(isOverviewPageLoaded){
            System.out.println(overviewPage.getPageTitle());
            flightsPage = overviewPage.selectFlightsPage();
        }
    }

    @Test(priority = 5)
    public void validateFlightDetails(){
        Assert.assertEquals(flightsPage.getOriginCountry(), "Dublin");
        Assert.assertEquals(flightsPage.getDestinationCountry(), "Barcelona");
        Assert.assertEquals(flightsPage.getDepartureDate(), "07 Jul");
        Assert.assertEquals(flightsPage.getReturnDate(), "14 Jul");
    }

    @Test(priority = 6)
    public void selectRegularFlights() throws InterruptedException {
        flightsPage.selectInboundRegularFlight();
        //flightsPage.selectOutboundRegularFlight();
    }

    @Test(priority = 7)
    public void validatePassengersSectionIsDisabled(){

    }

    @AfterTest
    public void tearDown(){
       // driver.quit();
    }

}
