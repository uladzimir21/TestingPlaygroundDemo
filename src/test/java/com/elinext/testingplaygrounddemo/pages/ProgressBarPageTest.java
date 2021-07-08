package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProgressBarPageTest extends BaseTest {
    ProgressBarPage page;

    @BeforeClass
    private void startClass() {
        page = new ProgressBarPage(driver);

        log().info("Tests in class ProgressBarPageTest started");
    }

    @AfterClass
    private void finishClass() {
        homePage.navigateToHome();
        log().info("Tests in class ProgressBarPageTest finished");
    }

    @Test
    public void testGetProgressValueAfterStopClicked() {
        homePage.navigateToPage(HomePage.PageLink.PROGRESS_BAR_PAGE.getXPath());
        page.clickStartButton();
        page.clickStopButton();
        assertEquals(page.getProgressValueAfterStopClicked(), page.getUntilValue());
    }
}