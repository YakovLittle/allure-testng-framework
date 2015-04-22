package pages.wm.office.dashboard;

import api.assertions.Assertions;
import dataclass.FinanceSummary;
import dataclass.FinanceSummaryForBuling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.WebElementHelper;
import pages.wm.BasePage;
import pages.wm.Spinners;
import pages.wm.office.dashboard.elements.Finance;
import pages.wm.office.dashboard.elements.HotOffers;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by s.lugovskiy on 04.03.2015 10:59.
 */
public class WmDashboardPage extends BasePage{


    private WebDriver driver;
    private Spinners spin;
    private HotOffers hot;
    private Finance finance;
    private WebElementHelper helper;

    public WmDashboardPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.spin = new Spinners(driver);
        this.helper = new WebElementHelper(driver);
    }

    @FindBy(xpath = "//a[contains(@class,'logotype')]")
    private Link logo;

    @FindBy(xpath = "//a[@class='with-hover-underline col-blacky']")
    private WebElement sudowm;

    @FindBy(xpath = "//a[@class='with-hover-underline col-blacky']")
    private WebElement userName;

    @Step("ВМ должен быть на сводной")
    public void isOnDashboard(){
        helper.fluentWait(By.xpath("//h2[contains(@class,'_overview_text')]"));
        helper.fluentWait(By.xpath("//img[@class='offer-screen']"));
        assertTrue(driver.getCurrentUrl().contains("office/dashboard"));
    }

    @Step("не должен быть на сводной")
    public void isNotOnDashboard(){
        assertFalse(driver.getCurrentUrl().contains("office/dashboard"));
    }

    @Step("ожидание загрузки")
    public void waitSpinner(){
        spin.waitSpinner();
    }

    @Step("останавливаем слайдер через джаваскрипт")
    public void stopSlider() {
        evaluateJavascript("_('#hotOffersSlider').pause(true)");
    }


    @Step("клик лого")
    public void clickLogo(){
        logo.click();
        spin.waitSpinner();
    }

    @Step("жду появления лого на сводной")
    public void waitLogo(){
        helper.fluentWait(By.xpath("//a[contains(@class,'logotype')]"));
    }

    @Step("ожидание прогруза  сводной для пустой сводной")
    public void waitDashboardBlank(){
        waitLogo();
        waitSpinner();

    }

    @Step("клик по первому офферу из топ предложений")
    public void goToFirstHotOffer(){
        //hot.clickFirstSwitch();
        evaluateJavascript("$('div._slide_switch').get(0).click();");
        waitSpinner();
        hot.clickTopOffer();
        spin.waitSpinner();
    }


    @Step("получение данных из финансовой сводной")
    @Attachment
    public FinanceSummary getFinanceSummary() {
        spin.waitJquery();
        spin.waitSpinner();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new FinanceSummary(
                finance.getBalance(),
                finance.getAvailable(),
                finance.getOnHold(),
                finance.getOnAdvPayment(),
                finance.getOnProcessing(),
                finance.getOnHoldTotal(),
                finance.getIssuedCredit()

        );
    }

    @Step("получение данных из финансовой сводной для билинга")
    @Attachment
    public FinanceSummaryForBuling getFinanceSummaryforBilling() {
        spin.waitJquery();
        spin.waitSpinner();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new FinanceSummaryForBuling(
                finance.getBalance(),
                finance.getAvailable(),
                finance.getOnHold(),
                finance.getOnAdvPayment(),
                finance.getOnProcessing(),
                finance.getOnHoldTotal(),
                finance.getIssuedCredit(),
                finance.getOpenCommision(),
                finance.getAprovedCommision(),
                finance.getFromLastPeriod(),
                finance.getFromThisMonth(),
                finance.getFeedAndOthers()
        );
    }


    @Attachment
    public String getSudowm() {
        return sudowm.getText();
    }

    @Step("Проверяем что пользователь авторизован на сводной")
    public void checkUser(String name) {
        Assertions.assertObjectsEquals(name,getUserName());
    }

    @Step
    @Attachment
    public String getUserName(){
        return userName.getText();
    }

}
