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
import ru.yandex.qatools.allure.annotations.Stories;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("авторизация через Oauth")
public class OAuthNegativeEmptyUserTest extends BaseTest {

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
    @Stories("авторизация c формы без редиректа не заполнен логин и пароль")
    public void emptyUserAuthorizationTest(){
        OAuthUser user = new OAuthUser("","");
        oauth.oauthLogin(user);
        oauth.checkFormVisible();
        oauth.checkErrorVisible();

    }


    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
