package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoadDelaysPage {
    private final Driver driver;

    private final By buttonLocator = By.xpath("//div[@class='container']/button");

    public LoadDelaysPage(Driver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Load Delays")) {
            throw new IllegalStateException("This is not Load Delays page." +
                    " You're now on: " + driver.getCurrentUrl());
        }
    }

    public void clickButton(WebDriverWait wait) {
        if (isPageCompletelyLoaded(wait))
            wait.until(ExpectedConditions.elementToBeClickable(buttonLocator)).click();
    }

    public boolean isPageCompletelyLoaded(WebDriverWait wait) {
        return wait
                .until(ExpectedConditions
                        .not(ExpectedConditions.invisibilityOfElementLocated(buttonLocator)));
    }
}
