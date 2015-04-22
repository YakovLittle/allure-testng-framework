package pages.wm.stat.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by s.lugovskiy on 15.04.2015 11:29.
 */
@Name("выпадающий список селекта")
@Block(@FindBy(xpath = "//div[@class='select-list']"))
public class SelectList extends HtmlElement {

    @Step("виден ли выпадающий список")
    public boolean isVisible(){
        return this.isDisplayed();
    }
}