package pages.wm.office.payments;

import dataclass.Payments2TableLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.WebElementHelper;
import pages.wm.BasePage;
import pages.wm.Spinners;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import setup.Printer;
import setup.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.hodakov on 11.03.2015.
 */
public class Payments2Page extends BasePage{

    private Utils utils;
    private WebDriver driver;
    private Spinners spin;
    private WebElementHelper helper;
    private ArrayList<Payments2TableLine> payments2List;

    private final By monthXpath = By.xpath(".//td[contains(@class,'event_time')]");
    private final By commission_open_wm = By.xpath(".//td[contains(@class,'commission_open_wm')]");
    private final By commission_rejected_wm = By.xpath(".//td[contains(@class,'commission_rejected_wm')]");
    private final By ommission_wm = By.xpath(".//td[contains(@class,'ommission_wm')]");
    private final By commission_pending_payment = By.xpath(".//td[contains(@class,'commission_pending_payment')]");
    private final By commission_hold = By.xpath(".//td[contains(@class,'commission_hold')]");
    private final By commission_system = By.xpath(".//td[contains(@class,'commission_system')]");
    private final By commission_adv = By.xpath(".//td[contains(@class,'commission_adv')]");
    private final By commission_available = By.xpath(".//td[contains(@class,'commission_available')]");
    private final By commission_processing = By.xpath(".//td[contains(@class,'commission_processing')]");
    private final By commission_paid = By.xpath(".//td[contains(@class,'commission_paid')]");

    private final By ommission_charge_back = By.xpath(".//td[contains(@class,'commission_charge_back')]");


    public Payments2Page(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.utils = new Utils(driver);
        this.spin = new Spinners(driver);
        this.helper = new WebElementHelper(driver);
    }

    @Step
    private List<WebElement> getPayments2Elements(){
        waitSpinner();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return utils.getWebElementsWithJquery("table[class*=\"blue_table\"]>tbody>tr");
    }

    @Step("Получаем массив с выплатами из таблицы в разделе Payments2")
    public ArrayList<Payments2TableLine> getPayments2List() {
        spin.waitJquery();
        waitSpinner();
        List<WebElement> lines = getPayments2Elements();
        ArrayList<Payments2TableLine> payments2 = new ArrayList<Payments2TableLine>();
        if(lines.size() != 0){
            for(WebElement elem : lines){
                Long chargebackSize = (Long) evaluateJavascript("return $('table[class*=\"blue_table\"]>tbody>tr>td[class*=\"commission_charge_back\"]').size();");
                int chargebackSizeInt = chargebackSize.intValue();
                if(chargebackSizeInt == 0) {
                    String month = elem.findElement(monthXpath).getText();
                    Float open = Float.valueOf(elem.findElement(commission_open_wm).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float cancelled = Float.valueOf(elem.findElement(commission_rejected_wm).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float approved = Float.valueOf(elem.findElement(ommission_wm).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float transferred = Float.valueOf(elem.findElement(commission_pending_payment).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float hold = Float.valueOf(elem.findElement(commission_hold).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float system = Float.valueOf(elem.findElement(commission_system).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float advertizers = Float.valueOf(elem.findElement(commission_adv).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float total = Float.valueOf(elem.findElement(commission_available).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float processing = Float.valueOf(elem.findElement(commission_processing).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float paid = Float.valueOf(elem.findElement(commission_paid).getText().replaceAll("’", "").replaceAll("'", ""));

                    Payments2TableLine payment = new Payments2TableLine(month,open,cancelled,approved,transferred,hold,system,advertizers,total,processing,paid);
                    Printer.println(payment.toString());
                    payments2.add(payment);
                    payment.logPayment();
                }
                else{
                    String month = elem.findElement(monthXpath).getText();
                    Float open = Float.valueOf(elem.findElement(commission_open_wm).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float cancelled = Float.valueOf(elem.findElement(commission_rejected_wm).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float approved = Float.valueOf(elem.findElement(ommission_wm).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float transferred = Float.valueOf(elem.findElement(commission_pending_payment).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float hold = Float.valueOf(elem.findElement(commission_hold).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float system = Float.valueOf(elem.findElement(commission_system).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float advertizers = Float.valueOf(elem.findElement(commission_adv).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float total = Float.valueOf(elem.findElement(commission_available).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float processing = Float.valueOf(elem.findElement(commission_processing).getText().replaceAll("’", "").replaceAll("'", ""));
                    Float paid = Float.valueOf(elem.findElement(commission_paid).getText().replaceAll("’", "").replaceAll("'", ""));

                    Float chargeback = Float.valueOf(elem.findElement(ommission_charge_back).getText().replaceAll("’", "").replaceAll("'", ""));

                    Payments2TableLine payment = new Payments2TableLine(month,open,cancelled,approved,transferred,hold,system,advertizers,total,processing,paid,chargeback);
                    Printer.println(payment.toString());
                    payments2.add(payment);
                    payment.logPayment();
                }
            }
        }

        return payments2;
    }

    @Step("ожидание загрузки")
    public void waitSpinner(){
        spin.waitSpinner();
    }





}
