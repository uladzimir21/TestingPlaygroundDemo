package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.ILogger;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickPage implements ILogger {
    private final WebDriver driver;

    private final By buttonLocator = By.id("badButton");

    public ClickPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButton() {
        return driver.findElement(buttonLocator);
    }

    @Step("Click the button")
    public void clickButton(WebDriverWait wait, WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        log().info("The class of clicked button is: " + getButtonClass());
    }

    public String getButtonClass() {
        WebElement button = getButton();
        return button.getAttribute("class");
    }

    public boolean isClickable(WebElement el, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(el));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
