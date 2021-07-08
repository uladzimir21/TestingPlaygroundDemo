package com.elinext.testingplaygrounddemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoadDelaysPage {
    private final WebDriver driver;

    private final By buttonLocator = By.xpath("//div[@class='container']/button");

    public LoadDelaysPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Waiting for page is completely downloaded, then click the button")
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
