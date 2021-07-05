import org.openqa.selenium.By;

public class MouseOverPage {
    protected Driver driver;

    private final By linkLocator = By.xpath("//div/a[text()='Click me']");
    private final By clickCounterLocator = By.xpath("//div[@class='container']/div/p/span[@id='clickCount']");

    public MouseOverPage(Driver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Mouse Over")) {
            throw new IllegalStateException("This is not Mouse Over page." +
                    " You're now on: " + driver.getCurrentUrl());
        }
    }

    public int getClickTimes() {
        for (int i = 0; i < 2; i++) {
            driver.findElement(linkLocator).click();
        }
        String result = driver.findElement(clickCounterLocator).getText();
        return Integer.parseInt(result);
    }
}
