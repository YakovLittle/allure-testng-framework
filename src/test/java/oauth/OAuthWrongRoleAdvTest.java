package oauth;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
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
public class OAuthWrongRoleAdvTest extends BaseTest {

    private FrontPage front;
    private OauthPage oauth;
    private WmDashboardPage dashboard;
    private Utils utils;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        oauth = new OauthPage(driver);
        dashboard = new WmDashboardPage(driver);

    }


    @BeforeMethod
    public void open(){
        utils.goToAuthStand();
    }

    @Test
    @Stories("раздел /advertiser_pro/offers/web_424509552.0.htm недоступен вебмастеру (перекидывает на главную)")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oAuthWrongRoleAdvTest() throws Exception {
        OAuthUser user = new OAuthUser();
        front.login(user);
        dashboard.waitDashboardBlank();
        dashboard.checkUser(user.getName());

        utils.goToAuthStandSection("/advertiser_pro/offers/web_424509552.0.htm");
        front.checkUserAuthorizedOnMain(user.getName());

    }


    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
