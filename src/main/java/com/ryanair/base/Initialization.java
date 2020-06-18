package com.ryanair.base;

import com.ryanair.utils.Log;
import com.ryanair.utils.PropUtils;
import com.ryanair.utils.TestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Initialization {

    private String baseUrl;
    private String browser;
    private PropUtils propUtils;
    public WebDriver driver;

    public void Initialization(){
        propUtils = new PropUtils();
        baseUrl = propUtils.getProperty("baseUrl");
        browser = propUtils.getProperty("browser");
    }

    public WebDriver openBrowser(){

        if(browser.equalsIgnoreCase("chrome")){
            driver = openChromeWebDriverManager();
            setDriverProperties();
            openBaseUrl();
        } else{
            Log.warn("Browsers other than chrome are not supported yet");
        }

        return driver;
    }

    private WebDriver openChromeBrowser() {

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:44444/wd/hub"), options);
        } catch (MalformedURLException e){
            Log.error(e.getMessage());
        } catch (Exception exception){
            Log.error(exception.getMessage());
        }
        return driver;
    }

    private WebDriver openChromeWebDriverManager(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    private void setDriverProperties(){
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    private void openBaseUrl(){
        driver.get(baseUrl);
    }

}
