package pages.mgr.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by a.hodakov on 11.03.2015.
 */

@Name("Mgr Filter Abstract")
@Block(@FindBy(xpath = "//table[contains(@class,'filter_table')]"))
public class FilterFooter extends HtmlElement{


    @FindBy(id="id_el_input_filter_search")
    private Button search;

    @FindBy(id="id_el_input_filter_reset")
    private Button reset;

    @Step("клик поиск в фильтре")
    public void clickSearch(){
        search.click();
    }

    @Step("клик сброс в фильтре")
    public void clickRest(){
        search.click();
    }

}
