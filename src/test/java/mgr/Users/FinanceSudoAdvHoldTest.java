package mgr.Users;

import api.assertions.Assertions;
import dataclass.FinanceSummary;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.mgr.dashboard.MgrDashboardPage;
import pages.mgr.users.UsersPage;
import pages.wm.Spinners;
import pages.wm.front.FrontPage;
import pages.wm.office.OfficePage;
import pages.wm.office.dashboard.WmDashboardPage;
import pages.wm.office.payments.PaymentsPage;
import roles.Manager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Printer;
import setup.Utils;
import wm.login.BaseTest;

import java.util.Arrays;

@Test
@Features("Финансы Вебмастера")
public class FinanceSudoAdvHoldTest extends BaseTest {



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
         /*return new Object[][] {
                {"sotta@ya.ru"}
        };*/
    }

    @Test(dataProvider = "url")
    @Stories("в холде у рекла = 0")
    @Severity(value = SeverityLevel.CRITICAL)
    public void financeAdvHoldTest(String url) throws InterruptedException {


        Printer.println("SUDO User: "+url);
/*      String randomStart = DataGenerator.getRandomIntNumber(100,10000);
        users.setBalance(randomStart,"");
        users.setHold("3","3");*/
        users.setUser(url);
        users.clickSearch();

        users.clickRandomSudo();
        wmdashboard.getSudowm();
        FinanceSummary dashboardSummary = wmdashboard.getFinanceSummary();
        office.goTopayments();
        FinanceSummary paymentsSummary = payments.getFinanceSummary();

        Float dashboardAdvHold = dashboardSummary.getOnAdvPayment();
        Float paymentAdvHold = paymentsSummary.getOnAdvPayment();
        Assertions.assertEqualsNull(dashboardAdvHold);
        Assertions.assertEqualsNull(paymentAdvHold);


    }

    @AfterMethod
    public void back(){
        String baseUrl = System.getProperty("baseUrl");
        driver.get(baseUrl+"/en/webmaster/office/dashboard?sudo=exit");
        mgrdashboard.goToUsers();
        //driver.get("http://beta.cityads.com/en/webmaster/office/dashboard?do=logout");
    }

    @AfterSuite
    public void close(){
        driver.quit();
    }


}
