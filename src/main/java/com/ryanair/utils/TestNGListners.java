package com.ryanair.utils;

import com.ryanair.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestNGListners extends BaseClass implements ITestListener {

    String status = "";
    String filePath = "results/failed_tests_screenshots/";

    @Override
    public void onTestStart(ITestResult tr) {
        log("Test Started....");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {

        log("Test '" + tr.getName() + "' PASSED");

        status = "Passed";

        // This will print the class name in which the method is present
        log(tr.getTestClass());

        // This will print the priority of the method.
        // If the priority is not defined it will print the default priority as
        // 'o'
        log("Priority of this method is " + tr.getMethod().getPriority());

        System.out.println(".....");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        status = "Failed";

        log("Test '" + tr.getName() + "' FAILED");
        log("Priority of this method is " + tr.getMethod().getPriority());
        String methodName = tr.getName().toString().trim();
        ITestContext context = tr.getTestContext();
        takeScreenShot(methodName);
        System.out.println(".....");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        status = "Skipped";
        log("Test '" + tr.getName() + "' SKIPPED");
        System.out.println(".....");
    }

    private void log(IClass testClass) {
        System.out.println(testClass);
    }
    private void log(String methodName) {
        System.out.println(methodName);
    }

    private void takeScreenShot(String methodName) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name
        try {
            File destFile = new File(filePath+methodName+ "_" + CommonUtilities.currentDate() + ".png");
            FileUtils.copyFile(scrFile, destFile);
            Reporter.log("<br><img src='"+destFile+"' height='300' width='300'/><br>");
            System.out.println("***Placed screen shot in "+filePath+" ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
