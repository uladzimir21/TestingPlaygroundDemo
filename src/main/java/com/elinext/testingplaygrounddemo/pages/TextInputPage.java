package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextInputPage {
    public static final String BUTTON_NAME = "New Button!!!";
    private final Driver driver;

    private final By textInputFieldLocator =
            By.xpath("//input[@id='newButtonName']");
    private final By buttonLocator = By.xpath("//button[@id]");

    public TextInputPage(Driver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Text Input")) {
            throw new IllegalStateException("This is not Text Input page." +
                    " You're now on: " + driver.getCurrentUrl());
        }
    }

    public void typeTextIn(WebDriverWait wait) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(textInputFieldLocator)).sendKeys(BUTTON_NAME);
    }

    public void pressButton(WebDriverWait wait) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
        element.click();
    }

    public String getInputtedText() {
        return BUTTON_NAME;
    }

    public String getButtonName() {
        WebElement element = driver.findElement(buttonLocator);
        return element.getText();
    }
}
