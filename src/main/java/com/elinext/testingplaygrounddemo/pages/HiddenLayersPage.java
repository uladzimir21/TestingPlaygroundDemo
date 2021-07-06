package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.ILogger;
import com.elinext.testingplaygrounddemo.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HiddenLayersPage implements ILogger {
    private final Driver driver;
    private String buttonColor;

    private final By colorButtons = By.xpath("//div[@id='spa']/div[@class='spa-view']");
    private final By greenButton = By.xpath("//div[@id='spa']/div[@class='spa-view']/button[@id='greenButton']");
    private final By blueButton = By.xpath("//div[@id='spa']/div[@class='spa-view']/button[@id='blueButton']");

    public HiddenLayersPage(Driver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Hidden Layers")) {
            throw new IllegalStateException("This is not Hidden Layers page." +
                    " You're now on: " + driver.getCurrentUrl());
        }
    }

    public void clickButton() {
        if (buttonSum() == 1) {
            driver.findElement(greenButton).click();
            buttonColor = "GREEN";
            log().info("Green Button clicked!");
        } else {
            driver.findElement(blueButton).click();
            buttonColor = "BLUE";
            log().info("Blue Button clicked!");
        }
    }

    public String getButtonColor() {
        return buttonColor;
    }

    private int buttonSum() {
        List<WebElement> buttons = driver.findElements(colorButtons);
        return buttons.size();
    }
}
