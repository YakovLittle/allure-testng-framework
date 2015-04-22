package wm.stat;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.wm.BasePage;
import pages.wm.Spinners;
import pages.wm.front.FrontPage;
import pages.wm.office.dashboard.WmDashboardPage;
import pages.wm.stat.StatPage;
import roles.OAuthUser;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("Статистика новая Реал-Тайм")
public class StatRealTimeTest extends BaseTest {

    private FrontPage front;
    private WmDashboardPage dashboard;
    private Utils utils;
    private WebDriver driver;
    private StatPage stat;
    private final String section = "/webmaster/statistika/standard/realtime";
    private Spinners spin;
    private BasePage page;

    @BeforeClass
    public void setUp(){

        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        dashboard = new WmDashboardPage(driver);
        stat = new StatPage(driver);
        spin = new Spinners(driver);
        page = new BasePage(driver);
        OAuthUser user = new OAuthUser();
        utils.goToAuthStand();
        front.login(user);
        dashboard.waitDashboard();
        utils.goToAuthStandSection(section);
        stat.waitRealTime();
    }

    @BeforeMethod
    public void waitPageLoad(){
        spin.waitSpinner();
    }


    @Test
    @Stories("графики")
    @Severity(value = SeverityLevel.CRITICAL)
    public void statRealTimeTest() throws Exception {
        stat.waitRealTime();
    }

    @Test
    @Stories("селект над графиком")
    @Severity(value = SeverityLevel.NORMAL)
    public void statRealTimeSelectTest() throws Exception {
        stat.checkSelectList();
    }

    @Test
    @Stories("селект сравнения над графиком")
    @Severity(value = SeverityLevel.NORMAL)
    public void statRealTimeSelectCompareTest() throws Exception {
        stat.checkCompareSelectList();
    }

    @Test
    @Stories("линейный тип графика")
    @Severity(value = SeverityLevel.NORMAL)
    public void statRealTimeLinearGraphTest() throws Exception {
        stat.checkLinearGraphType();
    }

    @Test
    @Stories("проверка наличия шапки")
    @Severity(value = SeverityLevel.CRITICAL)
    public void statRealTimeHeaderTest() throws Exception {
        page.checkHeader();
    }

    @Test
    @Stories("проверка наличия таблицы")
    @Severity(value = SeverityLevel.CRITICAL)
    public void statRealTimeTableTest() throws Exception {
        page.checkTable();
    }

    @Test
    @Stories("проверка наличия пагинатора")
    @Severity(value = SeverityLevel.NORMAL)
    public void statRealTimepaginatorTest() throws Exception {
        page.checkpaginator();
    }

    @AfterMethod
    public void clearState(){
        utils.refreshPage();
        stat.waitRealTime();
    }

    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
