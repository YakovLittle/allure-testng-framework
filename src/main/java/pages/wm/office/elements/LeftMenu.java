package pages.wm.office.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@Name("Меню навигации слева")
@Block(@FindBy(xpath = "//div[contains(@class,'div-menu')]"))
public class LeftMenu extends HtmlElement {

    @FindBy(id = "_left_menu_id_403459272")
    private WebElement payments;

    @Step("клик по первому переключателю в слайдере")
    public void clickPayments(){
        payments.click();
    }




}
