package wm.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.wm.office.dashboard.WmDashboardPage;
import pages.wm.front.FrontPage;
import pages.wm.offercard.OfferCardPage;
import roles.Webmaster;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;

@Test
@Features("Авторизация ВМа")
public class LoginTest extends BaseTest {

    private FrontPage front;
    private WmDashboardPage dashboard;
    private OfferCardPage card;
    private Webmaster wm;
    private Utils utils;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        dashboard = new WmDashboardPage(driver);
        card = new OfferCardPage(driver);
        wm = new Webmaster();
        utils.openMainPage();
        front.login(wm);
    }


    @Test
    @Stories("авторизация вма с правильными данными")
    @Severity(value = SeverityLevel.CRITICAL)
    public void loginTest() throws InterruptedException {
        dashboard.isOnDashboard();
        dashboard.waitSpinner();
    }

    @Test
    @Stories("проверка ссылки из блока Топовые предложения")
    @Severity(value = SeverityLevel.CRITICAL)
    public void hotOfferTest(){
        dashboard.isOnDashboard();
        dashboard.stopSlider();
        dashboard.goToFirstHotOffer();
        card.isOnDashboardTab();
    }


    @AfterMethod
    public void goBack(){
        dashboard.clickLogo();
    }


    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
