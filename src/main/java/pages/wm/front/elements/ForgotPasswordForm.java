package pages.wm.front.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by s.lugovskiy on 04.03.2015 11:15.
 */
@Name("Forgot password form")
@Block(@FindBy(xpath = ".//div[contains(@class,'form-webs')]/form[@method='post']"))
public class ForgotPasswordForm extends HtmlElement {


    @FindBy(name="email")
    private TextInput emailInput;

    @FindBy(name="lostpass")
    private TextInput submit;


}
