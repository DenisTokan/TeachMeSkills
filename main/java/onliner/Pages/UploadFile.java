package onliner.Pages;

import onliner.BasePageOnliner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UploadFile extends BasePageOnliner {
    public UploadFile(WebDriver driver) {
        super(driver);
    }
    public By chooseFile = By.xpath("//label[@class='drop-style__link']//input[@type='file']");
    public By image = By.cssSelector(".drop-style__upload-item.drop-style__upload-item_primary.drop-style__upload-item_repeat");


    public UploadFile sendFileName() {
        try {
            JavascriptExecutor j = (JavascriptExecutor) driver;
            j.executeScript("document.getElementsByClassName(\"drop-style__link-real\")[0].classList.remove(\"drop-style__link-real\");");
            driver.findElement(chooseFile).sendKeys("G:Безымянный.png");
        } catch (Exception e) {
        }
        return this;
    }
    public UploadFile verifyImageUploaded() {
        Assert.assertTrue(driver.findElement(image).isDisplayed());
        return this;
    }
}
