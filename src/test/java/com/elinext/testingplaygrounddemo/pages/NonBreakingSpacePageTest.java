package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import com.elinext.testingplaygrounddemo.driver.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NonBreakingSpacePageTest {
    WebDriver driver;
    HomePage homePage;
    NonBreakingSpacePage page;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);

        wait = new WebDriverWait(driver, 10);
        homePage.clickNonBreakingSpacePage(wait);
        page = new NonBreakingSpacePage(driver);
    }

    @Test
    public void testClickButton() {
        page.clickButton();
        Assert.assertEquals(page.getClassOfButton(), "btn btn-primary");
    }

    @Test(expectedExceptions = {NoSuchElementException.class})
    public void testClickNoSuchButton() {
        page.clickNoSuchButton();
    }

    @AfterTest
    public void destroy() {
        driver.quit();
    }
}