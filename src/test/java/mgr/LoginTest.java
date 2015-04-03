package mgr;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.wm.BasePage;
import pages.wm.Spinners;
import pages.wm.front.FrontPage;
import roles.Manager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("Авторизация Менеджера")
public class LoginTest extends BaseTest {



    private FrontPage front;
    private Manager mgr;
    private Utils utils;
    private WebDriver driver;
    private Spinners spin;
    private BasePage page;

    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        mgr = new Manager();
        spin = new Spinners(driver);
        page = new BasePage(driver);
        utils.openMainPage();
        front.login(mgr);
    }


    @Test
    @Stories("авторизация менеджера с правильными данными")
    @Severity(value = SeverityLevel.CRITICAL)
    public void loginTest() throws InterruptedException {
        page.waitDashboard();
        spin.waitSpinner();
    }

    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
