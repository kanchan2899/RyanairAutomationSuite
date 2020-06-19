package com.ryanair.utils;

import com.ryanair.webpages.functions.HomePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * This class contains the common utility methods related to the driver.
 */

public class WebDriverUtility {

    static final Logger logger = LogManager.getLogger(HomePage.class.getName());

    private static WebDriver driver;
    private static Actions actions;
    private static JavascriptExecutor javascriptExecutor;

    public WebDriverUtility(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    // Method to check if the page is loaded.
    public boolean checkIfPageIsLoaded(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        if(javascriptExecutor.executeScript("return document.readyState").toString().equalsIgnoreCase("complete")){
            logger.info("The page is loaded correctly");
            return true;
        }

        for(int i=0; i<25; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            if(javascriptExecutor.executeScript("return document.readyState").toString().equalsIgnoreCase("complete")){
                return true;
            }
        }

        return false;
    }

    // Method to return the page title
    public String getPageTitle(){
        return driver.getTitle();
    }

    // Method to click on a webelement using different approaches
    public static void click(WebElement element){
        try{
            element.click();
        } catch (Exception e1){
            try {
                javascriptExecutor.executeScript("arguments[0].click();", element);
            } catch (Exception e2){
                try {
                    int x = element.getLocation().getX();
                    int y = element.getLocation().getY();
                    actions.moveToElement(element, x, y).click().build().perform();
                } catch (Exception e3){

                }
            }
        }

    }

    // Method to type in a webelement field
    public static void type(WebElement element, String text){
        element.sendKeys(text);
    }

    // Method to clear the webelement field data
    public static void clearField(WebElement element){
        element.clear();
    }

    // Method to scroll down the page
    public void scrollDown(){
        javascriptExecutor.executeScript("window.scrollBy(0, "+ TestConstants.SCROLL_UP+ ");", "");
    }

    // Method to scroll up the page
    public void scrollUp(){
        javascriptExecutor.executeScript("window.scrollBy(0, " + TestConstants.SCROLL_DOWN + ");", "");
    }

}
