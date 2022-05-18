package onliner.Pages;

import onliner.BasePageOnliner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePageOnliner {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By Mail = By.xpath("(//input[@type='text'])[2]");
    private By Password = By.xpath("//input[@type='password']");
    private By Button = By.xpath("(//button[@type='submit'])[2]");
    private By Errormsg = By.xpath("//*[contains(@class,'auth-form__description_extended-other')]");
    private By CheckTxt = By.xpath("//div[@id='auth-container']/div/div[2]/div/div");

    public LoginPage CheckLoginPage(){
        driver.findElement(Mail).isDisplayed();
        driver.findElement(Password).isDisplayed();
        driver.findElement(Button).isDisplayed();
        Assert.assertEquals(getText(CheckTxt), "Вход");
        return this;
    }

    public LoginPage NegativeLogin(){
        driver.findElement(Mail).sendKeys("123");
        driver.findElement(Password).sendKeys("123");
        driver.findElement(Button).click();
        pause(1);
        Assert.assertEquals(getText(Errormsg), "Неверный логин или пароль");
        return this;
    }
}
