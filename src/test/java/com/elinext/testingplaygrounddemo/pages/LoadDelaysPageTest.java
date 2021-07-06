package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.driver.Driver;
import com.elinext.testingplaygrounddemo.pages.HomePage;
import com.elinext.testingplaygrounddemo.pages.LoadDelaysPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoadDelaysPageTest {
    Driver driver;
    HomePage homePage;
    LoadDelaysPage page;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);

        wait = new WebDriverWait(driver, 10);
        homePage.clickLoadDelayPage(wait);
        page = new LoadDelaysPage(driver);
    }

    @Test
    public void testClickButton() {
        page.clickButton(wait);
        assertTrue(page.isPageCompletelyLoaded(wait));
    }

    @AfterTest
    public void destroy() {
        driver.quit();
    }
}