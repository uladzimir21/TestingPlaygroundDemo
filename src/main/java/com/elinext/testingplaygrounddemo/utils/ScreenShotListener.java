package com.elinext.testingplaygrounddemo.utils;

import com.elinext.testingplaygrounddemo.ILogger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenShotListener extends ScreenShotter implements ITestListener, ILogger {
    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenShotForAttachment();
        takeScreenShotForFile();
        //saveScreenShotWithStatus("FAILURE");
        log().info("------- End of Test {}", result.getMethod().getDescription());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        takeScreenShotForAttachment();
        log().info("------- Test {}  skipped -------", result.getMethod().getDescription());
    }
}
