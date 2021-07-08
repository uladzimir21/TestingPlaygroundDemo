package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoadDelaysPageTest extends BaseTest {
    LoadDelaysPage page;

    @BeforeClass
    private void startClass() {
        page = new LoadDelaysPage(driver);

        log().info("Tests in class LoadDelaysPageTest started");
    }

    @AfterClass
    private void finishClass() {
        homePage.navigateToHome();
        log().info("Tests in class LoadDelaysPageTest finished");
    }

    @Test
    public void testClickButton() {
        homePage.navigateToPage(HomePage.PageLink.LOAD_DELAY_PAGE.getXPath());
        page.clickButton(wait);
        assertTrue(page.isPageCompletelyLoaded(wait));
    }
}