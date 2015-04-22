package pages.wm.stat.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@Name("контейнер с графиком")
@Block(@FindBy(xpath = "//div[@class='highcharts-container']"))
public class HighchartsContainer extends HtmlElement {


}



