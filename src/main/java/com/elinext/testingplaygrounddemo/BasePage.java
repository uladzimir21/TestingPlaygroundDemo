package com.elinext.testingplaygrounddemo;

import org.openqa.selenium.WebDriver;

public class BasePage {
    private static final String BASE_URL = "http://uitestingplayground.com";

    public BasePage(WebDriver driver) {
        driver.get(BASE_URL);
    }
}
