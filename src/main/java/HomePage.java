import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://uitestingplayground.com");
    }

    private final By hiddenLayersPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/hiddenlayers']");
    private final By clickPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/click']");
    private final By verifyTextPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/verifytext']");
    private final By mouseOverPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/mouseover']");

    //Method to click login button
    public void clickHiddenLayersPage(WebDriverWait wait) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(hiddenLayersPageLocator));
        element.click();
    }

    public void clickVerifyTextPage(WebDriverWait wait) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(verifyTextPageLocator));
        element.click();
    }

    public void clickClickPage(WebDriverWait wait) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickPageLocator));
        element.click();
    }

    public void clickMouseOverPage(WebDriverWait wait) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(mouseOverPageLocator));
        element.click();
    }
}
