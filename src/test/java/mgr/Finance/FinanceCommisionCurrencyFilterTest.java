package mgr.Finance;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
public class FinanceCommisionCurrencyFilterTest extends BaseTest {



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
    @Stories("проверка фильтрации комиссии по валюте в вкладке финансы")
    @Severity(value = SeverityLevel.NORMAL)
    public void curencyFilterRubTest() throws InterruptedException {

        finance.clickBychosenCheckbox(3,1);
        finance.checkCommisionInTableContainsChosenCurrency(3,1);


    }





    @AfterClass
    public void closebrowser(){
        driver.quit();
    }



}
