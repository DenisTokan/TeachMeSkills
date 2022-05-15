import Browser.Base;
import onliner.Pages.CatalogPage;
import onliner.Pages.CurrencyPage;
import onliner.Pages.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GraduateTest extends Base {

    @BeforeTest
    public void start(){
    driver.get("https://www.onliner.by/");
    }


    @Test(priority = 1)
    public void LimitValuesTest(){
        get(MainPage.class).GoToCurrency();
        get(CurrencyPage.class).CheckValue();
    }
    @Test(priority = 2)
    public void CheckMessage(){
        get(MainPage.class).checkMessage();
    }
    @Test(priority = 3)
    public void CreateEssense(){
        get(CatalogPage.class)
                .CreateEssense();
    }
    @Test(priority = 4)
    public void DeleteEssense(){
        get(CatalogPage.class).DelEssense();
    }
}
