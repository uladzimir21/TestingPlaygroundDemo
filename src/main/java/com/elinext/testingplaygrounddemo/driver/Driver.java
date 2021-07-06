package com.elinext.testingplaygrounddemo.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Driver implements WebDriver {
    private static final String DRIVER_NAME = "webdriver.chrome.driver";
    private static String DRIVER_PATH = "./src/main/resources/drivers/chromedriver";

    private static Driver driver;

    private final WebDriver webDriver;

    private Driver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static Driver getDriver() {
        setupOSBasedDriverPath();
        System.setProperty(DRIVER_NAME, DRIVER_PATH);
        if (driver == null) {
            driver = new Driver(new ChromeDriver());
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
                .webDriver
                .manage()
                .timeouts()
                .implicitlyWait(l, TimeUnit.SECONDS);
    }

    public void get(String url) {
        webDriver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webDriver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webDriver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return webDriver.getPageSource();
    }

    @Override
    public void close() {
        webDriver.close();
    }

    @Override
    public String getTitle() {
        return webDriver.getTitle();
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return webDriver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return webDriver.navigate();
    }

    @Override
    public Options manage() {
        return webDriver.manage();
    }
}
