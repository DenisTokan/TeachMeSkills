package onliner.Pages;

import onliner.BasePageOnliner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CurrencyPage extends BasePageOnliner {
    public CurrencyPage(WebDriver driver) {
        super(driver);
    }

    private By input = By.id("amount-in");


    public CurrencyPage CheckValue() {
        driver.findElement(input).sendKeys("10");
        driver.findElement(input).sendKeys("100");
        driver.findElement(input).sendKeys("1000");
        driver.findElement(input).sendKeys("10000");
        driver.findElement(input).sendKeys("100000");
        driver.findElement(input).sendKeys("1000000");
        return this;
    }
}