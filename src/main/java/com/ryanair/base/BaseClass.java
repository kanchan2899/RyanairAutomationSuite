package com.ryanair.base;

import com.ryanair.utils.TestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public static Properties properties;

    public BaseClass(){
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/main/java/com/ryanair/config/config.properties"));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialisation() {
        String browserName = properties.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Browsers other than chrome are not supported yet");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestConstants.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));

    }


}
