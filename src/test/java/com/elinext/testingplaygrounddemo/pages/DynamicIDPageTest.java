package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicIDPageTest extends BaseTest {
    DynamicIDPage page;

    @BeforeClass
    private void startClass() {
        page = new DynamicIDPage(driver);

        log().info("Tests in class DynamicIDPageTest started");
    }

    @AfterClass
    private void finishClass() {
        homePage.navigateToHome();
        log().info("Tests in class DynamicIDPageTest finished");
    }

    @Test
    public void testClickButton() {
        homePage.navigateToPage(HomePage.PageLink.DYNAMIC_ID_PAGE.getXPath());
        page.clickButton();
        Assert.assertEquals(page.getButtonName(), "Button with Dynamic ID");
    }

}