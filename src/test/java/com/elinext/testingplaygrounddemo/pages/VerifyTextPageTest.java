package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import com.elinext.testingplaygrounddemo.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyTextPageTest {
    WebDriver driver;
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