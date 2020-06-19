package com.ryanair.utils;

import com.ryanair.base.BaseClass;
import com.ryanair.webpages.functions.HomePage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;

/**
 * This class listens to the tests methods and provide more details on their success or failures.
 */
public class TestNGListners extends BaseClass implements ITestListener {

    String status = "";
    String filePath = "results/failed_tests_screenshots/";
    static final Logger logger = LogManager.getLogger(HomePage.class.getName());

    // Method to indicate that a test has been started
    @Override
    public void onTestStart(ITestResult tr) {
        logger.info("*******************Test Started***************");
    }

    // Method to print the status of the test method on success
    @Override
    public void onTestSuccess(ITestResult tr) {

        log("Test '" + tr.getName() + "' PASSED");
        status = "Passed";
        log(tr.getTestClass());
        log("Priority of this method is " + tr.getMethod().getPriority());
        System.out.println("\n\n");
    }

    // Method to print the status of the test method on failure and take a screenshot of a failed test method
    @Override
    public void onTestFailure(ITestResult tr) {
        status = "Failed";

        log("Test '" + tr.getName() + "' FAILED");
        log("Priority of this method is " + tr.getMethod().getPriority());
        String methodName = tr.getName().toString().trim();
        ITestContext context = tr.getTestContext();
        takeScreenShot(methodName);
        logger.info(".....");
    }

    // Method to indicate that the test method has been skipped
    @Override
    public void onTestSkipped(ITestResult tr) {
        status = "Skipped";
        log("Test '" + tr.getName() + "' SKIPPED");
        logger.info(".....");
    }

    // Method to print the test class name
    private void log(IClass testClass) {
        logger.info(testClass);
    }

    // Method to print the test method name
    private void log(String methodName) {
        logger.info(methodName);
    }

    // Method to take screenshot and save it in results folder
    private void takeScreenShot(String methodName) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            File destFile = new File(filePath+methodName+ "_" + CommonUtilities.currentDate() + ".png");
            FileUtils.copyFile(scrFile, destFile);
            Reporter.log("<br><img src='"+destFile+"' height='300' width='300'/><br>");
            System.out.println("*********Placed a screenshot in "+filePath+" **********");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
