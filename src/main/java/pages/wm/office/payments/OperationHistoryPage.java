package pages.wm.office.payments;

import dataclass.OperationsHistoryTableLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.WebElementHelper;
import pages.wm.BasePage;
import pages.wm.Spinners;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import setup.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.hodakov on 11.03.2015.
 */
public class OperationHistoryPage extends BasePage{

    private Utils utils;
    private WebDriver driver;
    private Spinners spin;
    private WebElementHelper helper;
    private ArrayList<OperationsHistoryTableLine> operationHistoryList;

    private final By dateXpath = By.xpath(".//td[contains(@class,'date')]");
    private final By accrualXpath = By.xpath(".//td[contains(@class,'value')]");
    private final By debitingXpath = By.xpath(".//td[contains(@class,'value_from')]");
    private final By detailsXpath = By.xpath(".//td[contains(@class,'tr_details')]");



    public OperationHistoryPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.utils = new Utils(driver);
        this.spin = new Spinners(driver);
        this.helper = new WebElementHelper(driver);
    }

    @Step
    private List<WebElement> getOperationHistoryElements(){
        waitSpinner();
        return utils.getWebElementsWithJquery("table[id=\"table_wm.charge_history\"]>tbody>tr");
    }

    @Step
    public ArrayList<OperationsHistoryTableLine> getOperationHistoryList(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<OperationsHistoryTableLine> list = new ArrayList<>();
        List<WebElement> lines = getOperationHistoryElements();

        if(lines.size() != 0){
            for(WebElement elem : lines){
                String date = elem.findElement(dateXpath).getText().replaceAll("’", "").replaceAll("'", "");
                float accural = Float.parseFloat(elem.findElement(accrualXpath).getText().replaceAll("’", "").replaceAll("'", ""));
                float debiting = Float.parseFloat(elem.findElement(debitingXpath).getText().replaceAll("’", "").replaceAll("'", ""));
                String details = elem.findElement(detailsXpath).getText().replaceAll("’", "").replaceAll("'", "");
                OperationsHistoryTableLine line = new OperationsHistoryTableLine(date,accural,debiting,details);
                if(!line.getDate().equals("2015-04-09")) {
                    list.add(line);
                    list.add(line);
                }
            }
        }

        return list;
    }










}
