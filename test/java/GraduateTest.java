import Browser.Base;
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

}
