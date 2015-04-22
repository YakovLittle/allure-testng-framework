package pages.mgr.users;

import api.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.WebElementHelper;
import pages.mgr.elements.FilterFooter;
import pages.mgr.users.elements.Filter;
import pages.wm.BasePage;
import pages.wm.Spinners;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import setup.Printer;

/**
 * Created by a.hodakov on 11.03.2015.
 */
public class UsersPage extends BasePage{
    private WebDriver driver;
    private Spinners spin;
    private WebElementHelper helper;
    private FilterFooter filterFooter;
    private Filter filter;

    public UsersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        HtmlElementLoader.populatePageObject(this, driver);
        this.spin = new Spinners(driver);
        this.helper = new WebElementHelper(driver);
    }

    @Step("устанавливаем холд в фильтре")
    public void setHold(String from,String to){

        filter.fillHoldFrom(from);
        filter.fillHoldTo(to);

    }

    @Step("устанавливаем баланс в фильтре")
    public void setBalance(String from,String to){

        filter.fillBalanceFrom(from);
        filter.fillBalanceTo(to);

    }

    @Step("фильтруем с заданными параметрами")
    public void clickSearch(){

        filterFooter.clickSearch();
        spin.waitSpinner();
    }

    @Step("кликаем на первое судо")
    public void clickFirstSudo(){
        this.evaluateJavascript("$('a[id*=\"id_el_link_enter\"]').get(0).click();");
        spin.waitSpinner();
    }


    @Step("кликаем на рандомное судо")
    public void clickRandomSudo(){
        this.evaluateJavascript("$('a[id*=\"id_el_link_enter\"]').eq(Math.random() * $('a[id*=\"id_el_link_enter\"]').length |0).get(0).click();");
        waitDashboard();
        spin.waitSpinner();
    }

    @Step
    public void setUser(String s) {
        Printer.println(s);
        filter.fillKeyword(s);
    }

    @Step("проверяем что фильтр в разделе Пользователи виден")
    public void checkFilterIsVisible() {
        Assertions.assertTrue(filter.isDisplayed());
    }

    @Step("ждем загрузку фильтра в разделе Пользователи")
    public void waitFilters() {
        helper.fluentWait(By.xpath("//table[contains(@class,'filter_table')]"));
    }
}
