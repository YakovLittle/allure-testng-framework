package oauth;

import api.assertions.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.oauth.OauthPage;
import pages.wm.front.FrontPage;
import pages.wm.office.dashboard.WmDashboardPage;
import roles.OAuthUser;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("авторизация через Oauth")
public class OAuthRedirectTest extends BaseTest {

    private FrontPage front;
    private OauthPage oauth;
    private WmDashboardPage dashboard;
    private Utils utils;
    private WebDriver driver;
    private final String section = "/webmaster/office/dashboard";

    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        oauth = new OauthPage(driver);
        dashboard = new WmDashboardPage(driver);
        dashboard.goToAuthStandSection(section);

    }


    @Test
    @Stories("авторизация c формы с редиректом")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oauthAuthorizeRedirect() throws Exception {
        OAuthUser user = new OAuthUser();
        oauth.oauthLogin(user);
        dashboard.waitDashboardBlank();
        dashboard.checkUser(user.getName());
        String currentUrl = utils.getCurrentUrl();
        Assertions.assertStringContains(currentUrl,section);

    }


    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
