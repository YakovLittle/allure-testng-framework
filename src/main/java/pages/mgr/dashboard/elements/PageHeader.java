package pages.mgr.dashboard.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * Created by a.hodakov on 11.03.2015.
 */


@Name("Top Header Mgr")
@Block(@FindBy(xpath = "//div[contains(@class,'top-menu')]"))
public class PageHeader  extends HtmlElement {

    @FindBy(id = "menu_top_wm_item_436351091")
    private Link users;

    @FindBy(id = "menu_top_wm_item_445571163")
    private Link offers2;

    @FindBy(id = "menu_top_wm_item_423250255")
    private Link instruments;

    @FindBy(id = "menu_top_wm_item_423010615")
    private Link statistic;

    @FindBy(id = "menu_top_wm_item_445781041")
    private Link finance;

    @FindBy(id = "menu_top_wm_item_19779")
    private Link requests;

    @FindBy(id = "menu_top_wm_item_17349")
    private Link company;

    @FindBy(id = "menu_top_wm_item_16239")
    private Link offers;

    @Step("Клик по ссылке Пользователи")
    public void clickUsers(){
        users.click();
    }

    @Step("Клик по ссылке Финансы")
    public void clickFinance(){finance.click();}
}



