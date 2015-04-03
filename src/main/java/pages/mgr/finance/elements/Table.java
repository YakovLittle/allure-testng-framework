package pages.mgr.finance.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

/**
 * Created by a.hodakov on 12.03.2015.
 */
@Name("Finance Table")
@Block(@FindBy(xpath = "//div[contains(@class,'ca-table')]"))
public class Table extends HtmlElement{

    @FindBy(className="(/div[@class='wide-table']/table)[1]")
    private WebElement tableHeader;

    @FindBy(className="//div[@class='tbl-control tbl-paginator']")
    private WebElement paginator;

    @FindBy(xpath=".//td[contains(@class,'_col-4')]")
    private List<WebElement> emails;

    @FindBy(xpath=".//table/tr[position()>2]")
    private WebElement tableTrs;

    @FindBy(xpath=".//td[position()=6 or position()=7]")
    private List<WebElement> commision;

    @FindBy(xpath=".//td[position()=8 or position()=9 or position()=10]")
    private List<WebElement> payout;


    @FindBy(xpath="(//a[@href='#'])[3]")
    private Link nextpage;


    @Attachment
    public String getFirstValueFromChosenColomnTable(int colomn){
        return findElements(By.xpath(".//td[contains(@class,'_col-"+colomn+"')]")).get(0).getText();
    }


    public List<WebElement> getChosenColomn(int colomn) {
        List<WebElement> list = findElements(By.xpath(".//td[contains(@class,'_col-"+colomn+"')]"));
        return list;
    }

    @Attachment
    public List<WebElement> getCommisionColomn() {
        List<WebElement> list = commision;
        return list;
    }


    public List<WebElement> getPayoutColomn() {
        List<WebElement> list = payout;
        return list;
    }

    @Attachment
    public String getTableTrs() {
        return tableTrs.getText();
    }

    @Step
    public void clickNextPage(){
        nextpage.click();
    }
}
