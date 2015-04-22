package oauth;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.oauth.OauthPage;
import pages.wm.front.FrontPage;
import pages.wm.office.dashboard.WmDashboardPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("авторизация через Oauth")
public class OAuthNewAccountTest extends BaseTest {

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
        utils.openOauthForm();
    }


    @Test
    @Stories("проверка ссылки У меня нет аккаунта")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oauthNewAccountTest() throws Exception {
        oauth.goToNewAccount();
        front.checkRegistrationFormVisible();

    }


    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
