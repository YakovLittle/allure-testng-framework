package oauth;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.mgr.users.UsersPage;
import pages.oauth.OauthPage;
import pages.wm.BasePage;
import pages.wm.Spinners;
import pages.wm.front.FrontPage;
import pages.wm.office.dashboard.WmDashboardPage;
import pages.wm.stat.StatPage;
import roles.TestAdvertizer;
import roles.User;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("авторизация через Oauth")
public class OAuthAdvertizerRedirectTest extends BaseTest {

    private FrontPage front;
    private OauthPage oauth;
    private WmDashboardPage dashboard;
    private Utils utils;
    private WebDriver driver;
    private UsersPage users;
    private Spinners spin;
    private BasePage page;
    private StatPage stat;

    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        oauth = new OauthPage(driver);
        spin = new Spinners(driver);
        dashboard = new WmDashboardPage(driver);
        users = new UsersPage(driver);
        page = new BasePage(driver);
        stat = new StatPage(driver);

    }



    @Test
    @Stories("авторизация рекламодателя по прямой ссылке в стату по офферам с редиректом ")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oauthAuthorizeAdvRedirectTest() throws Exception {

        User user = new TestAdvertizer();
        utils.goToAuthStandSection("/advertiser_pro/statistics/conversion/offers/offers_424809552.0.htm");
        oauth.oauthLogin(user);
        stat.waitOverview();
        spin.waitSpinner();
        stat.checkHeader();
        stat.checkHighchartsContainner();

    }





    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
