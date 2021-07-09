package com.elinext.testingplaygrounddemo.utils;

import com.elinext.testingplaygrounddemo.ILogger;
import com.elinext.testingplaygrounddemo.driver.Driver;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShotter implements ILogger {
    private static final String SCREENSHOTS_PATH = new File("src/main/resources/screenshots").getAbsolutePath();
    private final String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuu-MMM-dd HH-mm-ss"));

    public ScreenShotter() {
    }

    public void saveScreenShotWithStatus(String status) {
        File scrFile = takeScreenShotForFile();
        String screenShotName = status + "_" + currentTime + ".png";
        File destFile = new File(SCREENSHOTS_PATH + File.separator + screenShotName);

        try {
            FileUtils.copyFile(scrFile, destFile);
            log().info("ScreenShot saved into {}", destFile);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public File takeScreenShotForFile() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
    }

    @Attachment(type = "image/png")
    public byte[] takeScreenShotForAttachment() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
