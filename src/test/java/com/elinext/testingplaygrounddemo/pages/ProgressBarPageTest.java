package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProgressBarPageTest {
    WebDriver driver;
    HomePage homePage;
    ProgressBarPage page;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, 10);
        homePage.clickProgressBarPage(wait);
        page = new ProgressBarPage(driver);
    }

    @Test
    public void testGetProgressValueAfterStopClicked() {
        page.clickStartButton();
        page.clickStopButton();
        assertEquals(page.getProgressValueAfterStopClicked(), page.getUntilValue());
    }

    @AfterTest
    public void destroy() {
        driver.quit();
    }
}