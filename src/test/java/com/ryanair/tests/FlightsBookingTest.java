package com.ryanair.tests;

import com.ryanair.base.BaseClass;
import com.ryanair.webpages.functions.FlightsPage;
import com.ryanair.webpages.functions.HomePage;
import com.ryanair.webpages.functions.OverviewPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FlightsBookingTest extends BaseClass{

    private HomePage homePage;
    private OverviewPage overviewPage;
    private FlightsPage flightsPage;

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
    public void validateHomePageTitle(){
        String pageTitle = homePage.getPageTitle();
        Assert.assertEquals(pageTitle, "Official Ryanair website | Cheap flights from Ireland | Ryanair");
    }

    @Test (priority = 3)
    public void searchFlights(){
        homePage.selectCountries();
        homePage.selectDates();
        homePage.selectPassengers();
        overviewPage = homePage.clickSearchButton();
    }

    @Test(priority = 4)
    public void navigateToFlights() {
        boolean isOverviewPageLoaded = overviewPage.checkIfPageIsLoaded();
        Assert.assertTrue(isOverviewPageLoaded);
        flightsPage = overviewPage.selectFlightsPage();
    }

    @Test(priority = 5)
    public void validateFlightDetails(){
        Assert.assertEquals(flightsPage.getOriginCountry(), propUtils.getProperty("origin_country"));
        Assert.assertEquals(flightsPage.getDestinationCountry(), propUtils.getProperty("destination_country"));
        Assert.assertEquals(flightsPage.getDepartureDate(), "07 Jul");
        Assert.assertEquals(flightsPage.getReturnDate(), "14 Jul");
    }

    @Ignore
    @Test(priority = 6)
    public void selectRegularFlights() {
        flightsPage.selectInboundRegularFlight();
        //flightsPage.selectOutboundRegularFlight();
    }

    @AfterTest
    public void tearDown(){
        closeBrowser();
    }

}
