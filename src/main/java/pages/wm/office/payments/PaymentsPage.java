package pages.wm.office.payments;

import dataclass.FinanceSummary;
import org.openqa.selenium.WebDriver;
import pages.WebElementHelper;
import pages.wm.BasePage;
import pages.wm.Spinners;
import pages.wm.office.dashboard.elements.HotOffers;
import pages.wm.office.elements.LeftMenu;
import pages.wm.office.payments.elements.PayoutInfo;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by a.hodakov on 11.03.2015.
 */
public class PaymentsPage extends BasePage{
    private WebDriver driver;
    private Spinners spin;
    private HotOffers hot;
    private WebElementHelper helper;
    private LeftMenu leftmenu;
    private PayoutInfo payout;


    public PaymentsPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.spin = new Spinners(driver);
        this.helper = new WebElementHelper(driver);
    }


    @Step("получение данных из таблицы в начислениях и выплатах")
    @Attachment
    public FinanceSummary getFinanceSummary() {
        return new FinanceSummary(
                payout.getBalance(),
                payout.getAvailable(),
                payout.getOnHold(),
                payout.getOnAdvPayment(),
                payout.getOnProcessing(),
                payout.getIssuedCredit());
    }


}
