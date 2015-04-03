package pages.mgr.users.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by a.hodakov on 11.03.2015.
 */

@Name("User Filter")
@Block(@FindBy(xpath = "//table[contains(@class,'filter_table')]"))
public class Filter extends HtmlElement{

    @FindBy(id="id_el_input_text_from_hold_duration")
    private TextInput holdFrom;

    @FindBy(id="id_el_input_text_to_hold_duration")
    private TextInput holdTo;

    @FindBy(id="id_el_input_text_from_balance")
    private TextInput balanceFrom;

    @FindBy(id="id_el_input_text_to_balance")
    private TextInput balanceTo;

    @FindBy(id="id_el_text_field_email")
    private TextInput keyword;

    @Step
    public void fillHoldFrom(String num){
        holdFrom.clear();
        holdFrom.sendKeys(num);

    }

    @Step
    public void fillKeyword(String key){
        keyword.clear();
        keyword.sendKeys(key);

    }

    @Step
    public void fillHoldTo(String num) {
        holdTo.clear();
        holdTo.sendKeys(num);
    }

    @Step
    public void fillBalanceFrom(String num) {
        balanceFrom.clear();
        balanceFrom.sendKeys(num);
    }

    @Step
    public void fillBalanceTo(String num) {
        balanceTo.clear();
        balanceTo.sendKeys(num);
    }


}
