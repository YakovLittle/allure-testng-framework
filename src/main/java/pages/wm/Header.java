package pages.wm;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@Name("Хедер")
@Block(@FindBy(xpath = "(//div[contains(@class,'header')])[1]"))
public class Header extends HtmlElement {

}
