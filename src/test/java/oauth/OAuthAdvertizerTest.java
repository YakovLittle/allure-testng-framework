package oauth;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
public class OAuthAdvertizerTest extends BaseTest {

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
        utils.openOauthForm();
    }


    @Test
    @Stories("авторизация рекламодателя c формы без редиректа ")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oauthAuthorizeAdvDirect() throws Exception {

        User user = new TestAdvertizer();
        oauth.oauthLogin(user);
        //front.checkUserAuthorizedOnMain(user.getName());
        utils.goToAuthStandSection("/advertiser_pro/statistics/conversion/offers/offers_424809552.0.htm");
        stat.waitOverview();
        stat.checkHeader();

    }


    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
