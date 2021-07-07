package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import com.elinext.testingplaygrounddemo.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HiddenLayersPageTest {
    WebDriver driver;
    HomePage homePage;
    HiddenLayersPage page;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);

        wait = new WebDriverWait(driver, 10);
        homePage.clickHiddenLayersPage(wait);
        page = new HiddenLayersPage(driver);
    }

    @Test(priority = 0)
    public void clickGreenBtn() {
        page.clickButton();
        assertEquals(page.getButtonColor(), "GREEN");
    }

    @Test(priority = 1)
    public void clickBlueBtn() {
        page.clickButton();
        assertEquals(page.getButtonColor(), "BLUE");
    }

    @AfterTest
    public void destroy() {
        driver.quit();
    }
}