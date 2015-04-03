package wm.carcas;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.wm.office.dashboard.WmDashboardPage;
import pages.wm.front.FrontPage;
import pages.wm.offercard.OfferCardPage;
import roles.Webmaster;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("Ошибки в консоли")
//@Listeners(AllureOnFailListener.class)
public class CarcasTest extends BaseTest {



    private FrontPage front;
    private WmDashboardPage dashboard;
    private OfferCardPage card;
    private Webmaster wm;
    private Utils utils;
    private WebDriver driver;






    @DataProvider
    public Object[][] getUrl() {
        return new Object[][]{
                {"/ru/webmaster/instrumentyi/push_ads/getlink_445571172.0.htm"},
                {"/ru/webmaster/tools/feeds/coupons_feed_3641948.0.htm"},
                {"/ru/webmaster/tools/rotators/banners_rotator_416459372.0.htm"}

        };
    }



    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        dashboard = new WmDashboardPage(driver);
        card = new OfferCardPage(driver);
        wm = new Webmaster();
        utils.openMainPage();
        front.login(wm);
        dashboard.isOnDashboard();

    }



    @Test(dataProvider = "getUrl")
    @Stories(value = "проверка консоли браузера на наличие ошибок в разделах ВМа")
    @Severity(value = SeverityLevel.NORMAL)
    public void carcasTest(String url) throws InterruptedException {

        dashboard.goToSection(url);
        dashboard.waitSpinner();
        utils.checkConsoleLog();


    }


    @AfterClass
    public void closebrowser(){
        driver.quit();
    }




}
