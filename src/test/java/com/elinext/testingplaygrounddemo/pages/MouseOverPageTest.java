package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import com.elinext.testingplaygrounddemo.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseOverPageTest {
    WebDriver driver;
    HomePage homePage;
    MouseOverPage mouseOverPage;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);

        wait = new WebDriverWait(driver, 10);
        homePage.clickMouseOverPage(wait);
        mouseOverPage = new MouseOverPage(driver);
    }

    @Test
    public void testGetClickTimes() {
        int expected = 2;
        Assert.assertEquals(mouseOverPage.getClickTimes(), expected);
    }

    @AfterTest
    public void destroy() {
        driver.quit();
    }
}