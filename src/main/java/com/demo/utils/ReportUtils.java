package com.demo.utils;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ReportUtils {


    public void takeScreenshotOnFailure(WebDriver driver) {
        // Take screenshot (pseudo-code, depends on your WebDriver)
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Attach screenshot to the report
//        test.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot.getAbsolutePath()).build());
    }
}

