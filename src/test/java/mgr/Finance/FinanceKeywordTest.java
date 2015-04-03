package mgr.Finance;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.mgr.dashboard.MgrDashboardPage;
import pages.mgr.finance.FinancePage;
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
@Features("Финансы Менеджера фильтр")
public class FinanceKeywordTest extends BaseTest {



    private FrontPage front;
    private Manager mgr;
    private Utils utils;
    private WebDriver driver;
    private Spinners spin;
    private BasePage page;
    private MgrDashboardPage dashboard;
    private FinancePage finance;

    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        mgr = new Manager();
        spin = new Spinners(driver);
        page = new BasePage(driver);
        dashboard = new MgrDashboardPage(driver);
        finance = new FinancePage(driver);
        utils.openMainPage();
        front.login(mgr);
        page.waitDashboard();
        dashboard.goToFinance();
    }




    @Test
    @Stories("проверка поиска по ключевому слову email в вкладке финансы")
    @Severity(value = SeverityLevel.NORMAL)
    public void keywordEmailTest() throws InterruptedException {
        String email = finance.getFirstEmailFromTable();
        finance.searchByKeyword(email);
        String text = finance.getAllTextFromTable();
        utils.checkStringContainsString(text,email);

    }

    @Test
    @Stories("проверка поиска по ключевому слову id в вкладке финансы")
    @Severity(value = SeverityLevel.NORMAL)
    public void keywordIdTest() throws InterruptedException {
        String id = finance.getFirstIdFromTable();
        finance.searchByKeyword(id);
        String text = finance.getAllTextFromTable();
        utils.checkStringContainsString(text,id);

    }

    @Test
    @Stories("проверка поиска по ключевому слову name в вкладке финансы")
    @Severity(value = SeverityLevel.NORMAL)
    public void keywordNameTest() throws InterruptedException {
        String name = finance.getFirstNameFromTable();
        finance.searchByKeyword(name);
        String text = finance.getAllTextFromTable();
        utils.checkStringContainsString(text,name);

    }

    @Test
    @Stories("проверка поиска по ключевому слову Xkey в вкладке финансы")
    @Severity(value = SeverityLevel.NORMAL)
    public void keywordXkeyTest() throws InterruptedException {
        String xkey = finance.getFirstXkeyFromTable();
        finance.searchByKeyword(xkey);
        String text = finance.getAllTextFromTable();
        utils.checkStringContainsString(text,xkey);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        utils.goBack();
        spin.waitSmallSpinner();
    }

    @AfterClass
    public void closebrowser(){
        driver.quit();
    }



}
