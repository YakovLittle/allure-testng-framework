package pages.mgr.finance.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

/**
 * Created by a.hodakov on 12.03.2015.
 */
@Name("Finance Hedaer")
@Block(@FindBy(xpath = "//div[contains(@class,'top-bar-co')]"))
public class Header extends HtmlElement{

    @FindBy(xpath="(.//div[@class='ember-view drop-down'])[1]/a")
    private WebElement dropdown;

    @FindBy(xpath="//span[@class='currency-selector']/div[contains(@class,'ember-view drop-down')]/div[@class='ember-view drop-down-cnt']/a")
    private List<WebElement> currencylist;


    private WebElement getChosenCurrency(int num) {
        return currencylist.get(num);
    }

    public String getTextFromChosenCurrency(int num) {
        return currencylist.get(num).getText();
    }

    @Step
    public void selectCurrency(int num){
        dropdown.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {

        }
        getChosenCurrency(num).click();
    }

}
