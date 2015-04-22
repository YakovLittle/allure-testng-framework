package oauth;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.mgr.dashboard.MgrDashboardPage;
import pages.mgr.users.UsersPage;
import pages.oauth.OauthPage;
import pages.wm.BasePage;
import pages.wm.Spinners;
import pages.wm.front.FrontPage;
import pages.wm.office.OfficePage;
import pages.wm.office.dashboard.WmDashboardPage;
import pages.wm.office.payments.PaymentsPage;
import roles.Manager;
import roles.OAuthUser;
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
public class OauthSudoWmTest extends BaseTest {



    private FrontPage front;
    private Manager mgr;
    private Utils utils;
    private WebDriver driver;
    private Spinners spin;
    private MgrDashboardPage mgrdashboard;
    private UsersPage users;
    private WmDashboardPage wmdashboard;
    private PaymentsPage payments;
    private OfficePage office;
    private BasePage page;
    private OauthPage oauth;


    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        mgr = new Manager();
        spin = new Spinners(driver);
        mgrdashboard = new MgrDashboardPage(driver);
        wmdashboard = new WmDashboardPage(driver);
        payments = new PaymentsPage(driver);
        office = new OfficePage(driver);
        users = new UsersPage(driver);
        oauth = new OauthPage(driver);
        page = new MgrDashboardPage(driver);
        utils.openOauthForm();

    }

    @DataProvider
    public static Object[][] userName() {

        User oauthUser = new OAuthUser();
        String wm = oauthUser.getName();
         return new Object[][] {
                {wm}
        };
    }

    @Test(dataProvider = "userName")
    @Stories("менеджер: заход под судо через новую авторизацию ")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oauthSudoTest(String userName) throws InterruptedException {


        User user = new TestManager();
        oauth.oauthLogin(user);
        mgrdashboard.waitDashboard();
        mgrdashboard.goToUsers();
        users.setUser(userName);
        users.clickSearch();
        users.clickRandomSudo();
        wmdashboard.checkUser(userName);


    }


    @AfterSuite
    public void close(){
        driver.quit();
    }


}
