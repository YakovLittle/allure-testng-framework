package wm.corpsite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.wm.front.FrontPage;
import pages.wm.offercard.OfferCardPage;
import pages.wm.office.dashboard.WmDashboardPage;
import roles.Webmaster;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.CompareUtil;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("Корп сайт Главная страница")
public class ScreenTest extends BaseTest {

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
    }


    @Test
    @Stories("сравнение скриншота верхнего меню")
    @Severity(value = SeverityLevel.NORMAL)
    public void topMenuScreenTest() throws Exception {
        //String oldHeader = front.saveHeaderScreen();  для сохранения эталонного скрина с продакшена
        String header = front.getHeaderScreen();
        String newHeader = front.takeHeaderScreen();
        CompareUtil.compareImage(header,newHeader);

    }


    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
