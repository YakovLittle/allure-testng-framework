package mgr.Users;

import api.assertions.Assertions;
import dataclass.Payments2TableLine;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.mgr.dashboard.MgrDashboardPage;
import pages.mgr.users.UsersPage;
import pages.wm.Spinners;
import pages.wm.front.FrontPage;
import pages.wm.office.OfficePage;
import pages.wm.office.dashboard.WmDashboardPage;
import pages.wm.office.payments.Payments2Page;
import pages.wm.office.payments.PaymentsPage;
import roles.Manager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;

@Test
@Features("Финансы Вебмастера")
public class FinancePayments2WmTest extends BaseTest {



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
    @Stories("Payments 2 проверка столбцов")
    @Severity(value = SeverityLevel.CRITICAL)
    public void payments2Test(String url) throws InterruptedException {


        users.setUser(url);
        users.clickSearch();

        users.clickRandomSudo();
        wmdashboard.getSudowm();
        wmdashboard.goToSection("/webmaster/office/payments2");
        ArrayList<Payments2TableLine> list = payments2.getPayments2List();
        Assertions.checkPayments2List(list);

    }

    @AfterMethod
    public void back(){
        String baseUrl = System.getProperty("baseUrl");
        driver.get(baseUrl+"/en/webmaster/office/dashboard?sudo=exit");
        utils.printCurrentUrl();
        mgrdashboard.goToUsers();
    }

    @AfterSuite
    public void close(){
        driver.quit();
    }


}
