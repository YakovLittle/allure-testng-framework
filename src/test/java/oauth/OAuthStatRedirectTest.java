package oauth;

import api.assertions.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.oauth.OauthPage;
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
public class OAuthStatRedirectTest extends BaseTest {

    private FrontPage front;
    private OauthPage oauth;
    private WmDashboardPage dashboard;
    private Utils utils;
    private WebDriver driver;
    private StatPage stat;
    private final String section = "/webmaster/statistika/realtime/offers";

    @BeforeClass
    public void setUp(){

        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        oauth = new OauthPage(driver);
        dashboard = new WmDashboardPage(driver);
        stat = new StatPage(driver);
        dashboard.goToAuthStandSection(section);
    }


    @Test
    @Stories("авторизация c формы с редиректом на статистику")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oauthAuthorizeStatRedirect() throws Exception {

        OAuthUser user = new OAuthUser();
        oauth.oauthLogin(user);
        stat.waitRealTime();
        String currentUrl = utils.getCurrentUrl();
        Assertions.assertStringContains(currentUrl,section);
        stat.waitRealTime();

    }

    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
