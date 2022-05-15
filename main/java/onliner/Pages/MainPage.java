package onliner.Pages;

import onliner.BasePageOnliner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePageOnliner {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By Catalog = By.xpath("//div[@id='container']/div/div/header/div[2]/div/nav/ul/li/a[2]/span");
    private By Currency = By.xpath("//div[@id='container']/div/div/header/div[2]/div/nav/ul[2]/li/a/span");
    private By Login = By.xpath("//div[@id='userbar']/div/div/div/div");
    private By Electronics = By.xpath("//div[@id='container']/div/div/div/div/div/ul/li[3]/span[2]");
    private By Mobile = By.xpath("//div[@id='container']/div/div/div/div/div/div[4]/div/div[2]/div/div/div/div");
    private By Smartphones = By.xpath("//div[@id='container']/div/div/div/div/div/div[4]/div/div[2]/div/div/div/div[2]/div/a/span/span[3]");
    private By Message = By.xpath("//span[contains(.,'Да, верно')]");
    private By isMessage = By.className("popover-style__content");


    public MainPage GoToCatalog() {
        driver.findElement(Catalog).click();
        driver.findElement(Electronics).click();
        driver.findElement(Mobile).click();
        driver.findElement(Smartphones).click();
        return this;
    }
    public MainPage GoToCurrency(){
        isElementDisplayed(Currency);
        driver.findElement(Currency).click();
        return this;
    }
    public MainPage checkMessage(){
        driver.get("https://www.onliner.by/");
        driver.findElement(Catalog).click();
        driver.findElement(Electronics).click();
        driver.findElement(Mobile).click();
        driver.findElement(Smartphones).click();
        driver.findElement(isMessage).isDisplayed();
        driver.findElement(Message).click();
        return this;
    }


}
