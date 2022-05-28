import Browser.Base;
import onliner.Pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GraduateTest extends Base {

    @BeforeTest
    public void start(){
    driver.get("https://www.onliner.by/");
    }


    @Test(description = "Check value",priority = 1)
    public void LimitValuesTest(){
        get(MainPage.class).GoToCurrency();
        get(CurrencyPage.class).CheckValue();
    }
    @Test(description = "Check popup message",priority = 2)
    public void CheckMessage(){
        get(MainPage.class).checkMessage();
    }
    @Test(description = "Add phone to cart",priority = 3)
    public void CreateEssense(){
        get(CatalogPage.class)
                .CreateEssense();
    }
    @Test(description = "Remove phone from cart", priority = 4)
    public void DeleteEssense(){
        get(CatalogPage.class).DelEssense();
    }
    @Test(description = "Check dialog page", priority = 5)
    public void CheckLogin(){
        get(MainPage.class).CheckLogin();
        get(LoginPage.class).CheckLoginPage();
    }
    @Test(description = "Login with incorrect data", priority = 6)
    public void IncorrectLogin(){
        get(LoginPage.class).NegativeLogin();
    }
    @Test(description = "exceeding the values", priority = 7)
    public void ExceedingValues(){
        get(LoginPage.class).GoToRegistration();
        get(RegistrationPage.class)
                .CheckRegistrationPage()
                .IncorrectPassword();
    }
}
