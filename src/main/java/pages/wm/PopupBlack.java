package pages.wm;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;


@Name("Попап черный //div[contains(@class,'back-black') or contains(@class,'popup modal black')]")
@Block(@FindBy(xpath = "//div[contains(@class,'back-black') or contains(@class,'popup modal black')]"))
public class PopupBlack extends HtmlElement {

    @FindBy(xpath = ".//input[@type='text']")
    private TextInput input;

    @FindBy(xpath = ".//a[contains(@class,'submit') and contains(@class,'button dark')]")
    private Link submit;

    @Step
    public void fillInput(String text){
        input.clear();
        input.sendKeys(text);
    }

    @Step
    public void clickDynamicItem(String text){
        this.findElement(By.xpath(".//div[@class='ib' and @data-bind='text: name' and contains(text(),'"+text+"')]")).click();
    }

    public Link getSubmit() {
        return submit;
    }

    @Step
    public void clickSubmit(){
        submit.click();
    }
}
