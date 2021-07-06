import com.elinext.testingplaygrounddemo.driver.Driver;
import com.elinext.testingplaygrounddemo.pages.HiddenLayersPage;
import com.elinext.testingplaygrounddemo.pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HiddenLayersPageTest {
    Driver driver;
    HomePage homePage;
    HiddenLayersPage page;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);

        wait = new WebDriverWait(driver, 10);
        homePage.clickHiddenLayersPage(wait);
        page = new HiddenLayersPage(driver);
    }

    @Test(priority = 0)
    public void clickGreenBtn() {
        page.clickButton();
        assertEquals(page.getButtonColor(), "GREEN");
    }

    @Test(priority = 1)
    public void clickBlueBtn() {
        page.clickButton();
        assertEquals(page.getButtonColor(), "BLUE");
    }

    @AfterTest
    public void destroy() {
        driver.quit();
    }
}