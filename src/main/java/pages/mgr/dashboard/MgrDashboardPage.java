package pages.mgr.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.WebElementHelper;
import pages.mgr.dashboard.elements.PageHeader;
import pages.wm.BasePage;
import pages.wm.Spinners;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by a.hodakov on 11.03.2015.
 */
public class MgrDashboardPage extends BasePage{
    private WebDriver driver;
    private Spinners spin;
    private WebElementHelper helper;
    private PageHeader header;


    public MgrDashboardPage(WebDriver driver) {

        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.spin = new Spinners(driver);
        this.helper = new WebElementHelper(driver);

    }

    @Step("переход в раздел Пользователи")
    public void goToUsers(){
        spin.waitSpinner();
        header.clickUsers();
        spin.waitSpinner();

    }
    @Step("переход в финансы")
    public void goToFinance(){
        spin.waitSpinner();
        header.clickFinance();
        helper.fluentWait(By.xpath("//div[contains(@class,'ca-table')]"));
        spin.waitSmallSpinner();
    }



}
