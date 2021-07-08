package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HiddenLayersPageTest extends BaseTest {
    HiddenLayersPage page;

    @BeforeClass
    private void startClass() {
        page = new HiddenLayersPage(driver);

        log().info("Tests in class HiddenLayersPageTest started");
    }

    @AfterClass
    private void finishClass() {
        homePage.navigateToHome();
        log().info("Tests in class HiddenLayersPageTest finished");
    }

    @Test(priority = 0)
    public void clickGreenBtn() {
        homePage.navigateToPage(HomePage.PageLink.HIDDEN_LAYERS_PAGE.getXPath());
        page.clickButton();
        assertEquals(page.getButtonColor(), "GREEN");
    }

    @Test(priority = 1)
    public void clickBlueBtn() {
        page.clickButton();
        assertEquals(page.getButtonColor(), "BLUE");
    }
}