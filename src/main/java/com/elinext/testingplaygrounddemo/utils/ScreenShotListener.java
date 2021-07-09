package com.elinext.testingplaygrounddemo.utils;

import com.elinext.testingplaygrounddemo.ILogger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenShotListener extends ScreenShotter implements ITestListener, ILogger {
    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenShotForAttachment();
        saveScreenShotWithStatus("FAILED");
        log().info("------- Test failed -------");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        takeScreenShotForAttachment();
        saveScreenShotWithStatus("SKIPPED");
        log().info("------- Test skipped -------");
    }
}
