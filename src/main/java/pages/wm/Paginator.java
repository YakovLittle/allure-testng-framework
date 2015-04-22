package pages.wm;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@Name("Пагинатор под таблицей")
@Block(@FindBy(xpath = "//ul[contains(@class,'paginator_new')]"))
public class Paginator extends HtmlElement {

}
