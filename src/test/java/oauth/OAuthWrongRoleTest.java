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
public class OAuthWrongRoleTest extends BaseTest {

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
    @Stories("раздел /mng_new/finance/wm_payments недоступен вебмастеру (перекидывает на главную)")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oAuthWrongRoleMgrTest() throws Exception {
        OAuthUser user = new OAuthUser();
        front.waitLoad();
        front.login(user);
        dashboard.waitDashboardBlank();
        dashboard.checkUser(user.getName());

        utils.goToAuthStandSection("/mng_new/finance/wm_payments");
        front.checkUserAuthorizedOnMain(user.getName());

    }



    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
