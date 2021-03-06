package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.ILogger;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HiddenLayersPage implements ILogger {
    private final WebDriver driver;
    private String buttonColor;

    private final By colorButtons = By.xpath("//div[@id='spa']/div[@class='spa-view']");
    private final By greenButton = By.xpath("//div[@id='spa']/div[@class='spa-view']/button[@id='greenButton']");
    private final By blueButton = By.xpath("//div[@id='spa']/div[@class='spa-view']/button[@id='blueButton']");

    public HiddenLayersPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Performing two clicks: one for the green button, another for the blue one")
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
