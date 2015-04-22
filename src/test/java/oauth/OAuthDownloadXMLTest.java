package oauth;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.oauth.OauthPage;
import pages.wm.BasePage;
import pages.wm.Spinners;
import pages.wm.front.FrontPage;
import pages.wm.office.dashboard.WmDashboardPage;
import pages.wm.stat.StatPage;
import roles.OAuthUser;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("авторизация через Oauth")
public class OAuthDownloadXMLTest extends BaseTest {

    private FrontPage front;
    private OauthPage oauth;
    private WmDashboardPage dashboard;
    private Utils utils;
    private WebDriver driver;
    private StatPage stat;
    private Spinners spin;
    private BasePage page;

    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        oauth = new OauthPage(driver);
        dashboard = new WmDashboardPage(driver);
        stat = new StatPage(driver);
        spin = new Spinners(driver);
        page = new BasePage(driver);
        utils.openOauthForm();
    }


    @Test
    @Stories("выгрузка старой статы в XML")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oauthAuthorizeXMLDownloadTest() throws Exception {
        OAuthUser user = new OAuthUser();
        oauth.oauthLogin(user);
        page.waitTable();
        //front.checkUserAuthorizedOnMain(user.getName());
        utils.goToAuthStandSection("/ru/webmaster/statistika/standard_reports/offers_437201152.0.htm");
        stat.waitOverview();
        spin.waitSpinner();
        stat.export();


    }


    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
