package com.elinext.testingplaygrounddemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NonBreakingSpacePage {
    private final WebDriver driver;

    private final By button = By.xpath("//button[contains(text(),'Button')]");
    private final By noSuchButton = By.xpath("//button[text()='My Button']");

    public NonBreakingSpacePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click the blue button")
    public void clickButton() {
        getButton().click();
    }

    @Step("Click to nowhere")
    public void clickNoSuchButton() {
        getNoSuchButton().click();
    }

    private WebElement getButton() {
        return driver.findElement(button);
    }

    private WebElement getNoSuchButton() {
        return driver.findElement(noSuchButton);
    }

    public String getClassOfButton() {
        return getButton().getAttribute("className");
    }
}
