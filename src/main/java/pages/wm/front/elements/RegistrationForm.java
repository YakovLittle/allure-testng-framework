package pages.wm.front.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by s.lugovskiy on 04.03.2015 11:15.
 */
@Name("Registration form")
@Block(@FindBy(xpath = ".//div[contains(@class,'form')]/form[@id]"))
public class RegistrationForm extends HtmlElement {

    @FindBy(name="email")
    private TextInput emailInput;

}
