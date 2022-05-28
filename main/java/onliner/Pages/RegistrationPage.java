package onliner.Pages;

import onliner.BasePageOnliner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationPage extends BasePageOnliner {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private By CheckRegPage = By.xpath("//div[@id='container']/div/div/div/form/div[2]/div/div");
    private By EmailField = By.xpath("//input[@type='email']");
    private By PassField = By.xpath("//input[@type='password']");
    private By ProvePass = By.xpath("(//input[@type='password'])[2]");
    private By CheckBox = By.cssSelector(".i-checkbox__faux");
    private By Submit = By.xpath("//button[@type='submit']");
    private By Error = By.cssSelector(".auth-form__row:nth-child(6) .auth-form__description");

    public RegistrationPage CheckRegistrationPage(){
        Assert.assertEquals(getText(CheckRegPage), "Регистрация");
        driver.findElement(EmailField).isDisplayed();
        driver.findElement(PassField).isDisplayed();
        driver.findElement(ProvePass).isDisplayed();
        driver.findElement(Submit).isDisplayed();
        return this;
    }
    public RegistrationPage IncorrectPassword(){
        driver.findElement(PassField).sendKeys("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        driver.findElement(CheckBox).click();
        driver.findElement(Submit).click();
        pause(1);
        Assert.assertEquals(getText(Error), "Пароль должен быть от 8 до 64 символов");
        return this;
    }
}
