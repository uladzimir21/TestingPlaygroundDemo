package com.elinext.testingplaygrounddemo.utils;

import com.elinext.testingplaygrounddemo.driver.Driver;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShotter {
    private static final String screenshotsPath = new File("screenshots").getAbsolutePath();
    private File scrFile;

    public ScreenShotter() {
    }

    public void saveScreenShotWithStatus(String status) {
        File destFile = getScreenShotsPath(status);
        try {
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private File getScreenShotsPath(String status) {
        return new File(screenshotsPath + File.separator + getScreenArtifactPath(status));
    }

    private String getScreenArtifactPath(String status) {
        return createDir() + File.separator + status + ".png";
    }

    protected String createDir() {
        String PATH = "src/main/resources";
        String directoryName = PATH.concat(this.getClass().getSimpleName());

        File directory = new File(directoryName);
        directory.mkdir();

        System.out.println("Created directory for screenshots : " + directoryName);
        return directory.getAbsolutePath();
    }

    public File takeScreenShotForFile() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
    }

    @Attachment(type = "image/png")
    public byte[] takeScreenShotForAttachment() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public void setScrFile(File scrFile) {
        this.scrFile = scrFile;
    }
}
