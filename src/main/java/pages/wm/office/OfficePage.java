package pages.wm.office;

import org.openqa.selenium.WebDriver;
import pages.WebElementHelper;
import pages.wm.BasePage;
import pages.wm.Spinners;
import pages.wm.office.dashboard.elements.Finance;
import pages.wm.office.dashboard.elements.HotOffers;
import pages.wm.office.elements.LeftMenu;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by a.hodakov on 11.03.2015.
 */

public class OfficePage extends BasePage {


    private WebDriver driver;
    private Spinners spin;
    private HotOffers hot;
    private Finance finance;
    private WebElementHelper helper;
    private LeftMenu leftmenu;


    public OfficePage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.spin = new Spinners(driver);
        this.helper = new WebElementHelper(driver);
    }

    @Step("переход в Начисления и выплаты")
    public void goTopayments(){
        leftmenu.clickPayments();
        spin.waitSpinner();
    }
}
