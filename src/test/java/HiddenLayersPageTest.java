import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HiddenLayersPageTest {
    Driver driver;
    HiddenLayersPage page;

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
        driver.get("http://uitestingplayground.com/hiddenlayers");
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
}