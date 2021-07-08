package com.elinext.testingplaygrounddemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicIDPage {
    private final WebDriver driver;

    private final By button = By.xpath("//button[contains(text(),'Button with Dynamic ID')]");

    public DynamicIDPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click the blue button")
    public void clickButton() {
        getButton().click();
    }

    private WebElement getButton() {
        return driver.findElement(button);
    }
}
