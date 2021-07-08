package com.elinext.testingplaygrounddemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextInputPage {
    public static final String BUTTON_NAME = "New Button!!!";
    private final WebDriver driver;

    private final By textInputFieldLocator =
            By.xpath("//input[@id='newButtonName']");
    private final By buttonLocator = By.xpath("//button[@id]");

    public TextInputPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Type in the name of the button")
    public void typeTextIn(WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfElementLocated(textInputFieldLocator)).sendKeys(BUTTON_NAME);
    }

    @Step("Press the button in order to update its name")
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
