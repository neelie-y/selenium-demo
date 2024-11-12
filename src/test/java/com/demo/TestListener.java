package com.demo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Log the start of a test
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log success in the report
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log failure in the report
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log skipped test
        test.skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the report after tests are completed
        extent.flush();
    }
}
