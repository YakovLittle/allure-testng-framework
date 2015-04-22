package oauth;

import api.assertions.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.oauth.OauthPage;
import pages.wm.BasePage;
import pages.wm.Spinners;
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
public class OAuthNewMgrRedirectTest extends BaseTest {

    private OauthPage oauth;
    private Utils utils;
    private WebDriver driver;
    private BasePage page;
    private Spinners spin;

    @BeforeClass
    public void setUp(){

        driver = super.getDriver();
        utils = super.getUtils();
        oauth = new OauthPage(driver);
        page = new BasePage(driver);
        spin = new Spinners(driver);
        utils.goToAuthStandSection("/mng_new/finance");

    }


    @Test
    @Stories("авторизация менеджера c формы с редиректом на нового менеджера ")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oauthAuthorizeMgrRedirect() throws Exception {

        String section = "/mng_new/finance/wm_payments";
        User user = new TestManager();
        oauth.oauthLogin(user);
        page.waitTable();
        spin.waitSmallSpinner();
        String currentUrl = utils.getCurrentUrl();
        Assertions.assertStringContains(currentUrl, section);
        page.checkH1("Выплаты вебмастерам");


    }


    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
