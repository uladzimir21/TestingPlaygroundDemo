package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.ILogger;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProgressBarPage implements ILogger {
    private static final int UNTIL_VALUE = 75;
    private final WebDriver driver;

    private final By startButton = By.xpath("//div/button[@id='startButton']");
    private final By stopButton = By.xpath("//div/button[@id='stopButton']");
    private final By progressBar = By.xpath("//div/div[@id='progressBar']");

    private int progressValueAfterStopClicked;

    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Progress Bar")) {
            throw new IllegalStateException("This is not Progress Bar page." +
                    " You're now on: " + driver.getCurrentUrl());
        }
    }

    @Step("Click start button to make progressbar run")
    public void clickStartButton() {
        driver.findElement(startButton).click();

    }

    @Step("Click stop button if progress reach 75%")
    public void clickStopButton() {
        WebElement element = driver.findElement(progressBar);
        if (isProgressReached(element)) {
            driver.findElement(stopButton).click();
            progressValueAfterStopClicked = Integer.parseInt(element.getAttribute("ariaValueNow"));
        }
    }

    private boolean isProgressReached(WebElement element) {
        int currentProgressValue;
        do {
            currentProgressValue = Integer.parseInt(element.getAttribute("ariaValueNow"));
        } while (currentProgressValue != UNTIL_VALUE);
        log().info("75% is on the progressbar now!");
        return true;
    }

    public int getUntilValue() {
        return UNTIL_VALUE;
    }

    public int getProgressValueAfterStopClicked() {
        return progressValueAfterStopClicked;
    }
}
