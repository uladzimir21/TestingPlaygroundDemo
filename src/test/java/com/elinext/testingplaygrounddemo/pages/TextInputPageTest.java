package com.elinext.testingplaygrounddemo.pages;

import com.elinext.testingplaygrounddemo.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextInputPageTest extends BaseTest {
    TextInputPage page;

    @BeforeClass
    private void startClass() {
        page = new TextInputPage(driver);

        log().info("Tests in class TextInputPageTest started");
    }

    @AfterClass
    private void finishClass() {
        homePage.navigateToHome();
        log().info("Tests in class TextInputPageTest finished");
    }

    @Test
    public void testPressButton() {
        homePage.navigateToPage(HomePage.PageLink.TEXT_INPUT_PAGE.getXPath());
        page.typeTextIn(wait);
        page.pressButton(wait);
        assertEquals(page.getButtonName(), page.getInputtedText());
    }
}