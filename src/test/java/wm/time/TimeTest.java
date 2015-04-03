package wm.time;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.wm.Spinners;
import pages.wm.front.FrontPage;
import pages.wm.offercard.OfferCardPage;
import pages.wm.office.dashboard.WmDashboardPage;
import roles.Webmaster;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("Время загрузки")
public class TimeTest extends BaseTest {

    private FrontPage front;
    private WmDashboardPage dashboard;
    private OfferCardPage card;
    private Webmaster wm;
    private Utils utils;
    private WebDriver driver;
    private String url;
    private Spinners spin;



    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        dashboard = new WmDashboardPage(driver);
        card = new OfferCardPage(driver);
        wm = new Webmaster();
        spin = new Spinners(driver);
        utils.openMainPage();
        front.login(wm);
        dashboard.isOnDashboard();
        dashboard.waitSpinner();
    }

    @DataProvider
    public static Object[][] url() {
        return new Object[][] {
                {"/webmaster/offers/web_offers_3641940.0.htm"},
                {"/webmaster/statistika/standard/realtime_offers_437141152.0.htm"},
                {"/webmaster/products_and_coupons/coupons/coupons_and_promocodes_3641918.0.htm"},
                {"/webmaster/products_and_coupons/products/catalog_403319272.0.htm"},
                {"/webmaster/products_and_coupons/products/categories_403339272.0.htm"},
                {"/webmaster/instrumentyi/push_ads/getlink_445571172.0.htm"},
                {"/webmaster/tools/rotators/banners_rotator_416459372.0.htm"},
                {"/webmaster/tools/feeds/coupons_feed_3641948.0.htm"},
                {"/webmaster/tools/feeds/goods_feed_417519392.0.htm"},
                {"/webmaster/tools/back_url_446601153.0.htm"},
                {"/webmaster/tools/conversion_postback_423130345.0.htm"},
                {"/webmaster/offers/mobile_offers_407479372.0.htm"},
                {"/webmaster/office/account"},
                {"/webmaster/office/billing"},
                {"/webmaster/office/api"},
                {"/webmaster/office/payments"},
                {"/webmaster/office/history"},
                {"/webmaster/office/exchange"},
                {"/webmaster/statistika/standard_reports/offers_437201152.0.htm"},
                {"/webmaster/statistika/standard_reports/conversions_437231152.0.htm"},
                {"/webmaster/statistika/standard_reports/periods_437261152.0.htm"},
                {"/webmaster/statistics/conversions/segments/offers_426989753.0.htm"},
                {"/webmaster/statistics/realtime/offers_425229553.0.htm"},

           };
    }


    @Test(dataProvider = "url",timeOut = 8000)
    @Stories("проверка времени загрузки страниц")
    @Severity(value = SeverityLevel.NORMAL)
    public void timeTest(String url) throws InterruptedException {
        dashboard.goToSection(url);
        spin.waitSmallSpinner();
    }

    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
