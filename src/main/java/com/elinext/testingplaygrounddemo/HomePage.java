package com.elinext.testingplaygrounddemo;

import com.elinext.testingplaygrounddemo.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage implements ILogger {
    private final WebDriverWait wait;
//    private final By hiddenLayersPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/hiddenlayers']");
//    private final By clickPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/click']");
//    private final By verifyTextPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/verifytext']");
//    private final By mouseOverPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/mouseover']");
//    private final By loadDelayPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/loaddelay']");
//    private final By textInputPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/textinput']");
//    private final By progressBarPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/progressbar']");
//    private final By nonBreakingSpacePageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/nbsp']");
//    private final By dynamicIDPageLocator = By.xpath("//div[@class='col-sm']/h3/a[@href='/dynamicid']");

    public enum PageLink {
        HIDDEN_LAYERS_PAGE(By.xpath("//div[@class='col-sm']/h3/a[@href='/hiddenlayers']")),
        CLICK_PAGE(By.xpath("//div[@class='col-sm']/h3/a[@href='/click']")),
        VERIFY_TEXT_PAGE(By.xpath("//div[@class='col-sm']/h3/a[@href='/verifytext']")),
        MOUSE_OVER_PAGE(By.xpath("//div[@class='col-sm']/h3/a[@href='/mouseover']")),
        LOAD_DELAY_PAGE(By.xpath("//div[@class='col-sm']/h3/a[@href='/loaddelay']")),
        TEXT_INPUT_PAGE(By.xpath("//div[@class='col-sm']/h3/a[@href='/textinput']")),
        PROGRESS_BAR_PAGE(By.xpath("//div[@class='col-sm']/h3/a[@href='/progressbar']")),
        NON_BREAKING_SPACE_PAGE(By.xpath("//div[@class='col-sm']/h3/a[@href='/nbsp']")),
        DYNAMIC_ID_PAGE(By.xpath("//div[@class='col-sm']/h3/a[@href='/dynamicid']"));

        PageLink(By xpath) {
            this.xpath = xpath;
        }

        private final By xpath;

        public By getXPath() {
            return xpath;
        }
    }


    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
    }

    public void navigateToPage(By xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
        log().info("Navigating to the page by {} locator", xpath);
    }

    public void navigateToHome() {
        Driver.getDriver().navigate().back();
        log().info("Navigating back to the Home page");
    }

//    public HomePage(WebDriver driver) {
//        driver.get("http://uitestingplayground.com");
//    }


    //Method to click login button
//    public void clickHiddenLayersPage(WebDriverWait wait) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(hiddenLayersPageLocator));
//        log().info("Navigating to Hidden Layers Page by {} locator", hiddenLayersPageLocator);
//        element.click();
//    }
//
//    public void clickVerifyTextPage(WebDriverWait wait) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(verifyTextPageLocator));
//        log().info("Navigating to Verify Text Page by {} locator", verifyTextPageLocator);
//        element.click();
//    }
//
//    public void clickClickPage(WebDriverWait wait) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickPageLocator));
//        log().info("Navigating to Click Page by {} locator", clickPageLocator);
//        element.click();
//    }
//
//    public void clickMouseOverPage(WebDriverWait wait) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(mouseOverPageLocator));
//        log().info("Navigating to Mouse Over Page by {} locator", mouseOverPageLocator);
//        element.click();
//    }
//
//    public void clickLoadDelayPage(WebDriverWait wait) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loadDelayPageLocator));
//        log().info("Navigating to Load Delay Page by {} locator", loadDelayPageLocator);
//        element.click();
//    }
//
//    public void clickTextInputPage(WebDriverWait wait) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(textInputPageLocator));
//        log().info("Navigating to Text Input Page by {} locator", textInputPageLocator);
//        element.click();
//    }
//
//    public void clickProgressBarPage(WebDriverWait wait) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(progressBarPageLocator));
//        log().info("Navigating to Progress Bar Page by {} locator", progressBarPageLocator);
//        element.click();
//    }
//
//    public void clickNonBreakingSpacePage(WebDriverWait wait) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(nonBreakingSpacePageLocator));
//        log().info("Navigating to Non Breaking Space Page by {} locator", nonBreakingSpacePageLocator);
//        element.click();
//    }
//
//    public void clickDynamicIDPage(WebDriverWait wait) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dynamicIDPageLocator));
//        log().info("Navigating to Dynamic ID Page by {} locator", dynamicIDPageLocator);
//        element.click();
//    }
}
