package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseOverPageTest extends BaseTest {
    MouseOverPage page;

    @BeforeClass
    private void startClass() {
        page = new MouseOverPage(driver);

        log().info("Tests in class MouseOverPageTest started");
    }

    @AfterClass
    private void finishClass() {
        homePage.navigateToHome();
        log().info("Tests in class MouseOverPageTest finished");
    }

    @Test
    public void testGetClickTimes() {
        homePage.navigateToPage(HomePage.PageLink.MOUSE_OVER_PAGE.getXPath());
        int expected = 2;
        Assert.assertEquals(page.getClickTimes(), expected);
    }
}