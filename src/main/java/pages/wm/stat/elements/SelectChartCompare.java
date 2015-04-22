package pages.wm.stat.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@Name("селект показателей для сравнения графика")
@Block(@FindBy(xpath = "//div[contains(@class,'select _table_chart_select_lines_compare _with_clear')]"))
public class SelectChartCompare extends HtmlElement {

    @FindBy(xpath = ".//div[@class='select-choose pointer']")
    private WebElement selectPointer;

    @FindBy(className = "//div[@class='select-list")
    private WebElement selectList;

    @Step("клик на стрелку в селекте")
    public void clickSelect(){
        selectPointer.click();
    }


}



