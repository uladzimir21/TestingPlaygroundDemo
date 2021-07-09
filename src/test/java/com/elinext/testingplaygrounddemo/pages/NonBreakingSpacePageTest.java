package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NonBreakingSpacePageTest extends BaseTest {
    NonBreakingSpacePage page;

    @BeforeClass
    private void startClass() {
        page = new NonBreakingSpacePage(driver);

        log().info("Tests in class NonBreakingSpacePageTest started");
    }

    @AfterClass
    private void finishClass() {
        homePage.navigateToHome();
        log().info("Tests in class NonBreakingSpacePageTest finished");
    }

    @Test
    public void testClickButton() {
        homePage.navigateToPage(HomePage.PageLink.NON_BREAKING_SPACE_PAGE.getXPath());
        page.clickButton();
        Assert.assertEquals(page.getClassOfButton(), "btn btn-primary");
    }

    @Test(priority = 1, expectedExceptions = {NoSuchElementException.class})
    public void testClickNoSuchButton() {
        page.clickNoSuchButton();
    }
}