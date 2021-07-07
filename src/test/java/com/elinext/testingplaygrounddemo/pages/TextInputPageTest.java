package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import com.elinext.testingplaygrounddemo.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextInputPageTest {
    WebDriver driver;
    HomePage homePage;
    TextInputPage page;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);

        wait = new WebDriverWait(driver, 10);
        homePage.clickTextInputPage(wait);
        page = new TextInputPage(driver);
    }

    @Test
    public void testPressButton() {
        page.typeTextIn(wait);
        page.pressButton(wait);
        assertEquals(page.getButtonName(), page.getInputtedText());
    }

    @AfterTest
    public void destroy() {
        driver.quit();
    }
}