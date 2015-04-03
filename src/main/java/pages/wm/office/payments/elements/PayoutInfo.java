package pages.wm.office.payments.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by a.hodakov on 11.03.2015.
 */
@Name("Таблица выплат")
@Block(@FindBy(id = "table_wm.payout_info"))
public class PayoutInfo extends HtmlElement{

    @FindBy(id = "id_el_td_448_67_balance_1")
    private WebElement balance;

    @FindBy(id = "id_el_td_447371196_67_issued_credit_1")
    private WebElement issuedCredit;

    @FindBy(id = "id_el_td_447_67_balance_hold_1")
    private WebElement available;

    @FindBy(id = "id_el_td_516_67_hold_amount_1")
    private WebElement onHold;

    @FindBy(id = "id_el_td_447251197_67_on_adv_payment_1")
    private WebElement onAdvPayment;

    @FindBy(id = "id_el_td_446349925_67_request_1")
    private WebElement onProcessing;

    @Step
    @Attachment
    public Float getBalance() {
        return Float.parseFloat(balance.getText().replaceAll("’","").replaceAll("'",""));
    }

    @Step
    @Attachment
    public Float getAvailable() {
        return Float.parseFloat(available.getText().replaceAll("’","").replaceAll("'",""));
    }

    @Step
    @Attachment
    public Float getOnHold() {
        return Float.parseFloat(onHold.getText().replaceAll("’","").replaceAll("'",""));
    }

    @Step
    @Attachment
    public Float getOnAdvPayment() {
        return Float.parseFloat(onAdvPayment.getText().replaceAll("’","").replaceAll("'",""));
    }

    @Step
    @Attachment
    public Float getOnProcessing() {
        return Float.parseFloat(onProcessing.getText().replaceAll("’","").replaceAll("'",""));
    }

    @Step
    @Attachment
    public Float getIssuedCredit() {
        return Float.parseFloat(issuedCredit.getText().replaceAll("’","").replaceAll("'",""));
    }

}
