package pages.wm.office.dashboard.elements;

import dataclass.FinanceSummary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by s.lugovskiy on 04.03.2015 11:15.
 */
@Name("Финансовая сводная")
@Block(@FindBy(id = "mainSummary"))
public class Finance extends HtmlElement {

    @FindBy(xpath = ".//div[2]/div[13]/div[2]/nobr/div")
    private WebElement commision;

    @FindBy(xpath = "(//div[contains(@class,'ib col-blue')])[12]")
    private WebElement balance;

    @FindBy(xpath = "(//div[contains(@class,'ib col-blue')])[7]")
    private WebElement available;

    @FindBy(xpath = "(//div[contains(@class,'ib col-blue')])[10]")
    private WebElement onHold;

    @FindBy(xpath = "(//div[contains(@class,'ib col-blue')])[8]")
    private WebElement onAdvPayment;

    @FindBy(xpath = "(//div[contains(@class,'ib col-blue')])[11]")
    private WebElement onHoldTotal;

    @FindBy(xpath = "(//div[contains(@class,'ib col-blue')])[9]")
    private WebElement onProcessing;

    @FindBy(xpath = "(//div[contains(@class,'ib col-blue')])[3]")
    private WebElement issuedCredit;


    private FinanceSummary financeSummary;

    @Step
    @Attachment
    public Float getBalance() {
        return Float.parseFloat(balance.getText().replaceAll("’",""));
    }

    @Step
    @Attachment
    public Float getIssuedCredit() {
        return Float.parseFloat(issuedCredit.getText().replaceAll("’",""));
    }

    @Step
    @Attachment
    public Float getAvailable() {
        return Float.parseFloat(available.getText().replaceAll("’",""));
    }

    @Step
    @Attachment
    public Float getOnHold() {
        return Float.parseFloat(onHold.getText().replaceAll("’",""));
    }

    @Step
    @Attachment
    public Float getOnAdvPayment() {
        return Float.parseFloat(onAdvPayment.getText().replaceAll("’",""));
    }

    @Step
    @Attachment
    public Float getOnHoldTotal() {
        return Float.parseFloat(onHoldTotal.getText().replaceAll("’",""));
    }

    @Step
    @Attachment
    public Float getOnProcessing() {
        return Float.parseFloat(onProcessing.getText().replaceAll("’",""));
    }

}
