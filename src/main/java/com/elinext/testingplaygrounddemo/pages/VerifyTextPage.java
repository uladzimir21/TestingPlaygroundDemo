package com.elinext.testingplaygrounddemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyTextPage {
    protected WebDriver driver;
    private WebElement element;

    private final By textElementLocator = By.xpath("//div[@class='container']/div[@class='bg-primary']/span[text()[normalize-space()]]");

    public VerifyTextPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Verify Text")) {
            throw new IllegalStateException("This is not Verify Text." +
                    " You're now on: " + driver.getCurrentUrl());
        }
    }

    private WebElement getButton(By locator) {
        return driver.findElement(locator);
    }

    public void findTextElement() {
        element = driver.findElement(textElementLocator);
    }

    @Step("Extract the text value for check correctness")
    public String getTextFromElement() {
        return element.getAttribute("innerText");
    }
}
