package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyTextPageTest extends BaseTest {
    VerifyTextPage page;

    @BeforeClass
    private void startClass() {
        page = new VerifyTextPage(driver);

        log().info("Tests in class ClickPageTest started");
    }

    @AfterClass
    private void finishClass() {
        homePage.navigateToHome();
        log().info("Tests in class ClickPageTest finished");
    }

    @Test
    public void testFindTextElement() {
        homePage.navigateToPage(HomePage.PageLink.VERIFY_TEXT_PAGE.getXPath());
        page.findTextElement();
        Assert.assertEquals(page.getTextFromElement(), "Welcome UserName!");
    }
}