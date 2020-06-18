package com.ryanair.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {

    WebDriver driver;
    Actions actions;
    JavascriptExecutor javascriptExecutor;

    public WebDriverUtility(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public boolean checkIfPageIsLoaded(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        if(javascriptExecutor.executeScript("return document.readyState").toString().equalsIgnoreCase("complete")){
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

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void clickOnElement(WebElement element){
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();
        actions = new Actions(driver);
        actions.moveToElement(element, x, y).click().build().perform();
    }

    public void clickOnElementUsingJS(WebElement element){
        //javascriptExecutor.executeScript("window.scrollTo(0,'element.getLocation().y+')");
        //javascriptExecutor.executeScript("arguments[0].scrollIntoView()", element);
        //javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    public void scrollDown(){
        javascriptExecutor.executeScript("window.scrollBy(0, 50);", "");
    }

    public void scrollUp(){
        javascriptExecutor.executeScript("window.scrollBy(0, -250);", "");
    }

    public void switchToFrame(){

    }
}
