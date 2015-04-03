package pages.mgr.finance.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by a.hodakov on 12.03.2015.
 */
@Name("Finance Graph")
@Block(@FindBy(xpath = "//div[contains(@class,'ca-graph')]"))
public class Graph extends HtmlElement{

    @FindBy(className="summary-indicators")
    private WebElement summary;


}
