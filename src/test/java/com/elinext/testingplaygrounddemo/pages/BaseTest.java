package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import com.elinext.testingplaygrounddemo.ILogger;
import com.elinext.testingplaygrounddemo.driver.Driver;
import com.elinext.testingplaygrounddemo.utils.ScreenShotListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(ScreenShotListener.class)
public abstract class BaseTest implements ILogger {
    static HomePage homePage;
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeSuite
    public void setup() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
        homePage = new HomePage(driver, wait);
        driver.get("http://uitestingplayground.com");
    }

    @AfterSuite
    public void shutDown() {
        driver.quit();
    }
}
