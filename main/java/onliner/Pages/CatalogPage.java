package onliner.Pages;

import lombok.SneakyThrows;
import onliner.BasePageOnliner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CatalogPage extends BasePageOnliner {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    private By CheckBox = By.xpath("//div[@id='schema-filter']/div[5]/div[4]/div[2]/ul/li/label/span/span");
    private By ChosePhone = By.linkText("Смартфон Apple iPhone 13 128GB (темная ночь)");
    private By AddToCart = By.xpath("//a[contains(text(),'В корзину')]");
    private By GoToCart = By.linkText("Перейти в корзину");
    private By DelPhone = By.cssSelector("div[class$='remove'] div a");
    private By Text = By.cssSelector("[class$='extra']");

    public CatalogPage CreateEssense() {
        pause(3);
        driver.findElement(ChosePhone).click();
        driver.findElement(AddToCart).click();
        pause(2);
        driver.findElement(GoToCart).click();
        return this;
    }

    public CatalogPage DelEssense() {
        pause(2);
        moveToElementAndClick(DelPhone);
        pause(2);
        Assert.assertEquals(getText(Text), "Вы удалили Смартфон Apple iPhone 13 128GB (темная ночь)");
        return this;
    }
}
