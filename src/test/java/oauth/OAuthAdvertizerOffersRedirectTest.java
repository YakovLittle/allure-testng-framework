package oauth;

import api.assertions.Assertions;
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
public class OAuthAdvertizerOffersRedirectTest extends BaseTest {

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
    @Stories("авторизация рекламодателя по прямой ссылке в офферы с редиректом ")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oauthAuthorizeAdvOffersRedirectTest() throws Exception {

        User user = new TestAdvertizer();
        utils.goToAuthStandSection("/advertiser_pro/offers/web_424509552.0.htm");
        oauth.oauthLogin(user);

        page.waitTable();
        spin.waitSmallSpinner();
        page.checkHeader();
        //page.checkH1("Офферы");
        String url = utils.getCurrentUrl();
        Assertions.assertStringContains(url,"/advertiser_pro/offers");
        page.checkTable();



    }





    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
