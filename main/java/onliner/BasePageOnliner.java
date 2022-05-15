package onliner;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePageOnliner {
    public WebDriver driver;
    protected Actions actions;
    protected Logger log = Logger.getLogger(BasePageOnliner.class);
    protected WebDriverWait wait;

    public BasePageOnliner(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    protected WebElement getWebElement(By element) {
        log.debug("Get web element" + element);
        return driver.findElement(element);
    }

    protected BasePageOnliner wait(By element) {
        log.debug("Wait for " + element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getWebElement(element)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return this;
    }

    public Boolean isElementDisplayed(By element) {
        log.debug("Is element displayed: " + element);
        return getWebElement(element).isDisplayed();
    }

    public Boolean isElementEnabled(By element) {
        log.debug("Is element enabled: " + element);
        return getWebElement(element).isEnabled();
    }

    protected String getText(By element) {
        log.debug("Get text of element: " + element);
        return getWebElement(element).getText();
    }
}
