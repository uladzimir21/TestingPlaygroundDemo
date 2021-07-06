package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VerifyTextPage {
    protected Driver driver;
    private WebElement element;

    private final By textElementLocator = By.xpath("//div[@class='container']/div[@class='bg-primary']/span[text()[normalize-space()]]");

    public VerifyTextPage(Driver driver) {
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
        WebElement webElement = driver.findElement(textElementLocator);
        element = webElement;
    }

    public String getTextFromElement() {
        return element.getAttribute("innerText");
    }
}
