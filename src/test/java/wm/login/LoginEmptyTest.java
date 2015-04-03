package wm.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.wm.office.dashboard.WmDashboardPage;
import pages.wm.front.FrontPage;
import roles.Webmaster;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;

@Test
@Features("Авторизация ВМа")
//@Listeners(AllureOnFailListener.class)
public class LoginEmptyTest extends BaseTest {



    private FrontPage front;
    private WmDashboardPage dashboard;
    private Webmaster wm;
    private Utils utils;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        dashboard = new WmDashboardPage(driver);
        wm = new Webmaster("","");
        utils.openMainPage();
    }


    @Test
    @Stories("авторизация вма с незаполненными данными")
    @Severity(value = SeverityLevel.CRITICAL)
    public void loginEmptyTest() throws InterruptedException {
        front.login(wm);
        dashboard.isNotOnDashboard();
    }

    @AfterClass
    public void closebrowser(){
        driver.quit();
    }







}
