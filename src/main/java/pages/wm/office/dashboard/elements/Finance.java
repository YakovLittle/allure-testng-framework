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

    @FindBy(xpath = "//div/nobr/div[preceding::div[contains(text(),'Баланс аккаунта') or contains(text(),'Account balance') or contains(text(),'Saldo da Conta')]]")
    private WebElement balance;

    @FindBy(xpath = "(//div/nobr/div[preceding::div[contains(text(),'Итого доступно к выплате') or contains(text(),'Ending balance available for payment:') or contains(text(),'Total disponível para pagamento')]])[1]")
    private WebElement available;

    @FindBy(xpath = "(//div/nobr/div[preceding::div[contains(text(),'В холде') or contains(text(),'Hold') or contains(text(),'Retido')]])[1]")
    private WebElement onHold;

    @FindBy(xpath = "(//div/nobr/div[preceding::div[contains(text(),'В ожидании оплаты от рекламодателя') or contains(text(),'Pending payment from the advertiser') or contains(text(),'Aguardando pagamento de anunciante')]])[1]")
    private WebElement onAdvPayment;

    @FindBy(xpath = "(//div/nobr/div[preceding::div[contains(text(),'Итого комиссия на рассмотрении:') or contains(text(),'Total pending commissions') or contains(text(),'Total da comissão pendente')]])[1]")
    private WebElement onHoldTotal;

    @FindBy(xpath = "(//div/nobr/div[preceding::div[contains(text(),'На выводе:') or contains(text(),'Processing:') or contains(text(),'Pagamento em andamento:')]])[1]")
    private WebElement onProcessing;

    @FindBy(xpath = "(//div/nobr/div[preceding::div[contains(text(),'Использованный кредит:') or contains(text(),'Issued credit:') or contains(text(),'Issued credit')]])[1]")
    private WebElement issuedCredit;

    @FindBy(xpath = "(//div/nobr/div[preceding::div[contains(text(),'Открытая комиссия:') or contains(text(),'Open commissions:') or contains(text(),'Comissão aberta:')]])[1]")
    private WebElement openCommisions;

    @FindBy(xpath = "(//div/nobr/div[preceding::div[contains(text(),'Подтвержденная комиссия:') or contains(text(),'Approved commissions') or contains(text(),'Comissão confirmada:')]])[1]")
    private WebElement aprovedCommisions;

    @FindBy(xpath = "(//div/nobr/div[preceding::div[contains(text(),'прошлого периода') or contains(text(),' last period') or contains(text(),'período anterior')]])[1]")
    private WebElement fromLastPeriod;

    @FindBy(xpath = "(//div/nobr/div[preceding::div[contains(text(),'этом месяц') or contains(text(),'from this month') or contains(text(),'em mês atual')]])[1]")
    private WebElement fromThisMonth;

    @FindBy(xpath = "(//div/nobr/div[preceding::div[contains(text(),'Другие списания и ') or contains(text(),'Fees and ') or contains(text(),'Outros descontos')]])[1]")
    private WebElement feesAndOthers;

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
    public Float getOpenCommision() {
        return Float.parseFloat(openCommisions.getText().replaceAll("’",""));
    }

    @Step
    @Attachment
    public Float getAprovedCommision() {
        return Float.parseFloat(aprovedCommisions.getText().replaceAll("’",""));
    }

    @Step
    @Attachment
    public Float getFromLastPeriod() {
        return Float.parseFloat(fromLastPeriod.getText().replaceAll("’",""));
    }

    @Step
    @Attachment
    public Float getFromThisMonth() {
        return Float.parseFloat(fromThisMonth.getText().replaceAll("’",""));
    }

    @Step
    @Attachment
    public Float getFeedAndOthers() {
        return Float.parseFloat(feesAndOthers.getText().replaceAll("’",""));
    }

    @Step
    @Attachment
    public Float getOnProcessing() {
        return Float.parseFloat(onProcessing.getText().replaceAll("’",""));
    }


}
