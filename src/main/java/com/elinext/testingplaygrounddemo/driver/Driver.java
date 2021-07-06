package com.elinext.testingplaygrounddemo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static final String DRIVER_NAME = "webdriver.chrome.driver";
    private static String DRIVER_PATH = "./src/main/resources/drivers/chromedriver";

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        setupOSBasedDriverPath();
        System.setProperty(DRIVER_NAME, DRIVER_PATH);
        if (driver == null) {
            driver = new ChromeDriver();
            setupImplicitWait(10);
        }
        return driver;
    }

    private static void setupOSBasedDriverPath() {
        if (System.getProperty("os.name").toLowerCase().contains("win"))
            DRIVER_PATH += ".exe";
    }

    private static void setupImplicitWait(long l) {
        driver
                .manage()
                .timeouts()
                .implicitlyWait(l, TimeUnit.SECONDS);
    }
}
