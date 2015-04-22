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
import roles.TestManager;
import roles.User;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("авторизация через Oauth")
public class OAuthMgrTest extends BaseTest {

    private FrontPage front;
    private OauthPage oauth;
    private WmDashboardPage dashboard;
    private Utils utils;
    private WebDriver driver;
    private UsersPage users;
    private Spinners spin;
    private BasePage page;

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
        utils.openOauthForm();
    }


    @Test
    @Stories("авторизация менеджера c формы без редиректа ")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oauthAuthorizeMgrDirect() throws Exception {

        User user = new TestManager();
        oauth.oauthLogin(user);
        //front.checkUserAuthorizedOnMain(user.getName());
        utils.goToAuthStandSection("/mng_new/finance/wm_payments");
        page.waitMgrPage();
        page.checkH1("Выплаты вебмастерам");


    }


    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
