package pages.wm.stat.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by s.lugovskiy on 15.04.2015 11:29.
 */
@Name("динамика показателя")
@Block(@FindBy(xpath = "//div[contains(@class,'table-buttons-left')]/div[descendant::simplegroupcheck[@name='q_dynamics_param']]"))
public class Dynamic extends HtmlElement {

    @FindBy(xpath = ".//div[contains(@class,'_dd_button')]")
    private WebElement showDynamicButton;

    @Step("виден ли контейнер динамики")
    public boolean isVisible(){
        return this.isDisplayed();
    }

    @Step("клик по кнопке показа динамики")
    public void clickShowDynamic(){
        showDynamicButton.click();
    }


}