package pages.wm.offercard;

import org.openqa.selenium.WebDriver;
import pages.wm.BasePage;
import pages.wm.offercard.elements.DashboardTab;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static org.testng.Assert.assertTrue;

/**
 * Created by s.lugovskiy on 06.03.2015 16:47.
 */
public class OfferCardPage extends BasePage {

    DashboardTab dashboardTab;

    public OfferCardPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
    }

    @Step("должен быть на карточке оффера таб сводная")
    public void isOnDashboardTab(){
        assertTrue(dashboardTab.isOnOfferCard());
    }


}
