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
@Features("Статистика новая По Офферам")
public class StatByOffersTest extends BaseTest {

    private FrontPage front;
    private WmDashboardPage dashboard;
    private Utils utils;
    private WebDriver driver;
    private StatPage stat;
    private final String section = "/webmaster/statistika/standard/offers";
    private Spinners spin;
    private BasePage page;

    @DataProvider
    public Object[][] dynamicParameter() {
        return new Object[][] {
                {"Показы"},
                {"Хиты"},
                {"Клики"},
                {"Back URL"},
                {"Открытые лиды"},
                {"Одобренные лиды"},
                {"Все лиды"},
                {"Открытые продажи"},
                {"Отклоненные продажи"},
                {"Одобренные продажи"},
                {"Все продажи"},
                {"Leads CR"},
                {"Sales CR"},
                {"Total CR"},
                {"Все конверсии"},
                {"Открытая"},
                {"Отклонена"}
        };
    }


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
        dashboard.waitLogo();
        utils.goToAuthStandSection(section);

    }

    @BeforeMethod
    public void waitPageLoad(){
        stat.waitOverview();
        spin.waitSpinner();
    }

    @Test
    @Stories("проверка наличия шапки")
    @Severity(value = SeverityLevel.CRITICAL)
    public void statByOfferHeaderTest() throws Exception {
       page.checkHeader();
    }

    @Test
    @Stories("селект над графиком")
    @Severity(value = SeverityLevel.NORMAL)
    public void statByOffersSelectTest() throws Exception {
        stat.checkSelectList();
    }

    @Test
    @Stories("селект сравнения над графиком")
    @Severity(value = SeverityLevel.NORMAL)
    public void statByOffersSelectCompareTest() throws Exception {
        stat.checkCompareSelectList();
    }

    @Test
    @Stories("линейный тип графика")
    @Severity(value = SeverityLevel.NORMAL)
    public void statByOffersLinearGraphTest() throws Exception {
        stat.checkLinearGraphType();
    }

    @Test
    @Stories("проверка наличия шапки")
    @Severity(value = SeverityLevel.CRITICAL)
    public void statByOffersHeaderTest() throws Exception {
        page.checkHeader();
    }

    @Test
    @Stories("проверка наличия таблицы")
    @Severity(value = SeverityLevel.CRITICAL)
    public void statByOffersTableTest() throws Exception {
        page.checkTable();
    }

    @Test
    @Stories("проверка наличия пагинатора")
    @Severity(value = SeverityLevel.NORMAL)
    public void statByOfferspaginatorTest() throws Exception {
        page.checkpaginator();
    }

    @Test(dataProvider = "dynamicParameter")
    @Stories("проверка динамики")
    @Severity(value = SeverityLevel.NORMAL)
    public void statByOffersDynamicTest(String dynamic_parameter) throws Exception {
        stat.checkDynamicContainer();
        stat.setDynamics(dynamic_parameter);
        stat.checkDynamicThText(dynamic_parameter);
        stat.checkFirstDynamicTdVisible();
    }



    @AfterMethod
    public void clearState(){
        utils.refreshPage();
    }

    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
