package oauth;

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
public class OAuthNegativeTest extends BaseTest {

    private FrontPage front;
    private OauthPage oauth;
    private WmDashboardPage dashboard;
    private Utils utils;
    private WebDriver driver;
    private OAuthUser user;

    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        oauth = new OauthPage(driver);
        dashboard = new WmDashboardPage(driver);

        user = new OAuthUser("kjdhfkldhjasfklhjasdfkljhasdfkljhaskd","123kj1;l3kj1kl2j31;l2k3j");

        utils.goToAuthStand();

    }


    @Test
    @Stories("авторизация c формы без редиректа неправильный пароль")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oauthAuthorizationWrongUserTest() throws Exception {

        front.login(user);
        oauth.checkFormVisible();
        oauth.checkErrorVisible();


    }



    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
