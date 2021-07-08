package com.elinext.testingplaygrounddemo.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        setupOSBasedWebDriverManager();

        if (driver == null) {
            driver = new ChromeDriver();
            setupImplicitWait(10);
        }
        return driver;
    }

    private static void setupOSBasedWebDriverManager() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            WebDriverManager
                    .chromedriver()
                    .arch64()
                    .win()
                    .setup();
        } else {
            WebDriverManager
                    .chromedriver()
                    .arch64()
                    .linux()
                    .setup();
        }
    }

    private static void setupImplicitWait(long l) {
        driver
                .manage()
                .timeouts()
                .implicitlyWait(l, TimeUnit.SECONDS);
    }
}
