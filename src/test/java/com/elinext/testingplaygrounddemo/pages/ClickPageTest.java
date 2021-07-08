package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClickPageTest extends BaseTest {
    ClickPage page;

    @BeforeClass
    private void startClass() {
        page = new ClickPage(driver);

        log().info("Tests in class ClickPageTest started");
    }

    @AfterClass
    private void finishClass() {
        homePage.navigateToHome();
        log().info("Tests in class ClickPageTest finished");
    }


    @Test(priority = 0)
    @Description("Check class identity if the button color has changed.")
    public void testButtonColor() {
        homePage.navigateToPage(HomePage.PageLink.CLICK_PAGE.getXPath());
        WebElement button = page.getButton();
        page.clickButton(wait, button);

        Assert.assertEquals(this.page.getButtonClass(), "btn btn-success");
    }

    @Test(priority = 1)
    @Description("Check if the button is clickable after color has changed.")
    public void testClickButton() {
        WebElement button = page.getButton();
        page.clickButton(wait, button);

        Assert.assertTrue(page.isClickable(button, driver));
    }
}