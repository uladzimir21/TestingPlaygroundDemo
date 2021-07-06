package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.ILogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage implements ILogger {

    public HomePage(WebDriver driver) {
        driver.get("http://uitestingplayground.com");
    }

    private final By hiddenLayersPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/hiddenlayers']");
    private final By clickPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/click']");
    private final By verifyTextPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/verifytext']");
    private final By mouseOverPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/mouseover']");
    private final By loadDelayPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/loaddelay']");
    private final By textInputPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/textinput']");
    private final By progressBarPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/progressbar']");

    //Method to click login button
    public void clickHiddenLayersPage(WebDriverWait wait) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(hiddenLayersPageLocator));
        log().info("Navigating to Hidden Layers Page by {} locator", hiddenLayersPageLocator);
        element.click();
    }

    public void clickVerifyTextPage(WebDriverWait wait) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(verifyTextPageLocator));
        log().info("Navigating to Verify Text Page by {} locator", verifyTextPageLocator);
        element.click();
    }

    public void clickClickPage(WebDriverWait wait) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickPageLocator));
        log().info("Navigating to Click Page by {} locator", clickPageLocator);
        element.click();
    }

    public void clickMouseOverPage(WebDriverWait wait) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(mouseOverPageLocator));
        log().info("Navigating to Mouse Over Page by {} locator", mouseOverPageLocator);
        element.click();
    }

    public void clickLoadDelayPage(WebDriverWait wait) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loadDelayPageLocator));
        log().info("Navigating to Load Delay Page by {} locator", loadDelayPageLocator);
        element.click();
    }

    public void clickTextInputPage(WebDriverWait wait) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(textInputPageLocator));
        log().info("Navigating to Text Input Page by {} locator", textInputPageLocator);
        element.click();
    }

    public void clickProgressBarPage(WebDriverWait wait) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(progressBarPageLocator));
        log().info("Navigating to Text Input Page by {} locator", progressBarPageLocator);
        element.click();
    }
}
