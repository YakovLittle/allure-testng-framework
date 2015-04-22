package oauth;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("авторизация через Oauth")
public class OAuthTimeTest extends BaseTest {

    private Utils utils;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
    }


    @Test(timeOut = 1000)
    @Stories("загрузка формы авторизации не более секунды")
    @Severity(value = SeverityLevel.MINOR)
    public void oauthTimeTest() throws Exception {
        utils.openOauthForm();
    }


    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
