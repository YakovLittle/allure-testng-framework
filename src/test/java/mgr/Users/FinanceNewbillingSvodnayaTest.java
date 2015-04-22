package mgr.Users;

import api.assertions.Assertions;
import dataclass.FinanceSummaryForBuling;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.mgr.dashboard.MgrDashboardPage;
import pages.mgr.users.UsersPage;
import pages.wm.Spinners;
import pages.wm.front.FrontPage;
import pages.wm.office.OfficePage;
import pages.wm.office.dashboard.WmDashboardPage;
import pages.wm.office.payments.OperationHistoryPage;
import pages.wm.office.payments.Payments2Page;
import pages.wm.office.payments.PaymentsPage;
import roles.Manager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

import java.util.Arrays;

@Test
@Features("Новый билинг")
public class FinanceNewbillingSvodnayaTest extends BaseTest {



    private FrontPage front;
    private Manager mgr;
    private Utils utils;
    private WebDriver driver;
    private Spinners spin;
    private MgrDashboardPage mgrdashboard;
    private UsersPage users;
    private WmDashboardPage wmdashboard;
    private PaymentsPage payments;
    private OfficePage office;
    private Payments2Page payments2;
    private OperationHistoryPage operations;




    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        mgr = new Manager();
        spin = new Spinners(driver);
        mgrdashboard = new MgrDashboardPage(driver);
        wmdashboard = new WmDashboardPage(driver);
        payments = new PaymentsPage(driver);
        office = new OfficePage(driver);
        users = new UsersPage(driver);
        payments2 = new Payments2Page(driver);
        operations = new OperationHistoryPage(driver);
        utils.openMainPage();
        front.login(mgr);
        mgrdashboard.waitDashboard();
        mgrdashboard.goToUsers();
    }

    @DataProvider
    public static Object[][] url() {

        String[] w = System.getProperty("wms").split(",");
        System.out.println(Arrays.deepToString(w));
        int size = w.length;
        String[][] data = new String[size][1];
        int i;
        for(i=0;i<size;i++){
            data[i][0] = w[i];
        }
        System.out.println(Arrays.deepToString(data));
        return data;

    }

    @Test(dataProvider = "url")
    @Stories("dashboard  сравнение")
    @Severity(value = SeverityLevel.CRITICAL)
    public void dashboardTest(String url) throws InterruptedException {

        String n = "100";
        users.setUser(url);
        users.clickSearch();
        users.clickRandomSudo();
        wmdashboard.getSudowm();
        operations.waitSpinner();
        spin.waitJquery();

        FinanceSummaryForBuling dashboardSummary = wmdashboard.getFinanceSummaryforBilling();
        wmdashboard.goToSection("/ru/webmaster/office/dashboard?nb=test");
        FinanceSummaryForBuling dashboardSummaryNew = wmdashboard.getFinanceSummaryforBilling();
        Assertions.assertObjectsEquals(dashboardSummary,dashboardSummaryNew);
        spin.waitSpinner();


    }

    @AfterMethod
    public void back(){
        String baseUrl = System.getProperty("baseUrl");
        String exit = baseUrl+"/en/webmaster/office/dashboard?sudo=exit".replace("//","/");
        driver.get(exit);
        utils.printCurrentUrl();
        mgrdashboard.goToUsers();
    }

    @AfterSuite
    public void close(){
        driver.quit();
    }


}
