package com.elinext.testingplaygrounddemo.pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MouseOverPage {
    protected WebDriver driver;

    private final By linkLocator = By.xpath("//div/a[text()='Click me']");
    private final By clickCounterLocator = By.xpath("//div[@class='container']/div/p/span[@id='clickCount']");

    public MouseOverPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Due to the fact that DOM is changing its values when link is clicked,
     * it's a very important to perform all of the clicks before and extract
     * the amount of clicks after that.
     *
     * @return the amount of link clicks
     */

    @Description(useJavaDoc = true)
    @Step("Click on the link and extract amount of clicks from the dynamic field")
    public int getClickTimes() {
        for (int i = 0; i < 2; i++) {
            driver.findElement(linkLocator).click();
        }
        String result = driver.findElement(clickCounterLocator).getText();
        return Integer.parseInt(result);
    }
}
