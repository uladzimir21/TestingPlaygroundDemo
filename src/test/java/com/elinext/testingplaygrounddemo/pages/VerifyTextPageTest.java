package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.driver.Driver;
import com.elinext.testingplaygrounddemo.pages.HomePage;
import com.elinext.testingplaygrounddemo.pages.VerifyTextPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyTextPageTest {
    Driver driver;
    HomePage homePage;
    VerifyTextPage verifyTextPage;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, 10);
        homePage.clickVerifyTextPage(wait);
        verifyTextPage = new VerifyTextPage(driver);
    }

    @Test
    public void testFindTextElement() {
        verifyTextPage.findTextElement();
        Assert.assertEquals(verifyTextPage.getTextFromElement(), "Welcome UserName!");
    }

    @AfterTest
    public void destroy() {
        driver.quit();
    }
}