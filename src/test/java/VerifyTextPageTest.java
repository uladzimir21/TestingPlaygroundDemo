import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyTextPageTest {
    Driver driver;
    HomePage homePage;
    VerifyTextPage verifyTextPage;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);

        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testFindTextElement() {
        homePage.clickVerifyTextPage(wait);
        verifyTextPage = new VerifyTextPage(driver);
        verifyTextPage.findTextElement();
        Assert.assertEquals(verifyTextPage.getTextFromElement(), "Welcome UserName!");
    }

    @AfterClass
    public void destroy() {
        driver.quit();
    }
}