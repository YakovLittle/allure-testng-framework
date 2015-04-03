package highload;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("Генерация Show Id")
public class ShowIdTest extends BaseTest {

    private Utils utils;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
    }


    @Test
    @Stories ("Генерация Show Id Aliexpress")
    @Severity(value = SeverityLevel.CRITICAL)
    public void showIdTest() throws InterruptedException {

        utils.setDebugCookie();
        utils.openUrl("http://cityadspix.com/click-HQBPFD0A-KHEBQPTK");
        String text = driver.getPageSource();

        String clickId = utils.getClickId(text);
        System.out.println("Click ID ---> " + clickId);

        String finalUrl = utils.getFinalUrl(text);
        System.out.println("Final URL ---> " + finalUrl);

        String dp = utils.getDp(finalUrl);
        System.out.println("DP ---> " + dp);

        utils.openUrl("http://cityads.ru/monitor/api/decode-click?click_id=" + dp);
        String text2 = driver.getPageSource();
        String clickId2 = utils.getClickId(text2);
        System.out.println("Click ID decoded ---> " + clickId2);

        utils.checkStringEquals(clickId,clickId2);
    }



    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
