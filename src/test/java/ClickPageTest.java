import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickPageTest {
    Driver driver;
    HomePage homePage;
    ClickPage page;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, 10);
        homePage.clickClickPage(wait);
    }

    @Test(priority = 0)
    public void testButtonColor() {
        page = new ClickPage(driver);
        WebElement button = page.getButton();
        page.clickButton(wait, button);

        Assert.assertEquals(this.page.getButtonClass(), "btn btn-success");
    }

    @Test(priority = 1)
    public void testClickButton() {
        page = new ClickPage(driver);
        WebElement button = page.getButton();
        page.clickButton(wait, button);

        Assert.assertTrue(page.isClickable(button, driver));
    }

    @AfterClass
    public void destroy() {
        driver.quit();
    }
}