package pages.wm.stat.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;


@Name("график кнопки типов периодов")
@Block(@FindBy(xpath = "//div[contains(@class,'span2 text-right _types')]"))
public class GraphLegendTypes extends HtmlElement {

    @FindBy(xpath = ".//a[@data-value='60']")
    private Link min1;

    @FindBy(xpath = ".//a[@data-value='300']")
    private Link min5;

    @FindBy(xpath = ".//a[@data-value='600']")
    private Link min10;

    @FindBy(xpath = ".//a[@data-value='1']")
    private Link sec1;

    @FindBy(xpath = ".//a[@data-value='5']")
    private Link sec5;

    @FindBy(xpath = ".//a[@data-value='15']")
    private Link sec15;

    @FindBy(xpath = ".//a[@data-value='linear']")
    private Link linear;

    @FindBy(xpath = ".//a[@data-value='column']")
    private Link column;

    @Step("клик на линейный тип графика")
    public void  clickLinear(){
        linear.click();
    }

    @Step
    public Link getLinear() {
        return linear;
    }
}



