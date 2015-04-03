package pages.mgr.finance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.WebElementHelper;
import pages.mgr.dashboard.elements.PageHeader;
import pages.mgr.finance.elements.Filter;
import pages.mgr.finance.elements.Header;
import pages.mgr.finance.elements.Table;
import pages.wm.BasePage;
import pages.wm.Spinners;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.List;
import java.util.Objects;

import static org.testng.Assert.assertTrue;

/**
 * Created by a.hodakov on 12.03.2015.
 */


public class FinancePage extends BasePage{

    private WebDriver driver;
    private Spinners spin;
    private WebElementHelper helper;
    private PageHeader header;
    private Table table;
    private Filter filter;
    private Header fheader;

    public FinancePage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.spin = new Spinners(driver);
        this.helper = new WebElementHelper(driver);

    }

    @Step("проверяем что столбец Email отфильтрован")
    public void checkEmailsContainsText(String email){
        List<WebElement> emails = table.getChosenColomn(4);
        for(WebElement elem: emails){
            System.out.println(elem.getText());
            assertTrue(elem.getText().contains(email));
        }

    }

    @Step("проверяем что столбец Xkey отфильтрован")
    public void checkXkeyContainsText(String email){
        List<WebElement> emails = table.getChosenColomn(3);
        for(WebElement elem: emails){
            System.out.println(elem.getText());
            assertTrue(elem.getText().contains(email));
        }

    }

    @Step("проверяем что столбец Name отфильтрован")
    public void checkNameContainsText(String email){
        List<WebElement> emails = table.getChosenColomn(2);
        for(WebElement elem: emails){
            System.out.println(elem.getText());
            assertTrue(elem.getText().contains(email));
        }

    }

    @Step("проверяем что столбец Id отфильтрован")
    public void checkIdContainsText(String email){
        List<WebElement> emails = table.getChosenColomn(1);
        for(WebElement elem: emails){
            System.out.println(elem.getText());
            assertTrue(elem.getText().contains(email));
        }

    }

    @Step("проверяем что столбец commision отфильтрован по валюте")
    public void checkCommisionContainsText(String currency){
        List<WebElement> commision = table.getCommisionColomn();
        for(WebElement elem: commision){
            System.out.println(elem.getText());
            assertTrue(elem.getText().contains(currency));
        }

    }

    @Step("проверяем что столбец выплаты отфильтрован по валюте")
    public void checkPayoutContainsText(String currency){
        List<WebElement> commision = table.getPayoutColomn();
        for(WebElement elem: commision){
            System.out.println(elem.getText());
            if(!Objects.equals(elem.getText(), "")){
                assertTrue(elem.getText().contains(currency));
            }
        }

    }


    @Step("получаем первый email из списка ")
    public String getFirstEmailFromTable(){
        return table.getFirstValueFromChosenColomnTable(4);
    }

    @Step("получаем первый id из списка ")
    public String getFirstIdFromTable(){
        return table.getFirstValueFromChosenColomnTable(1);
    }

    @Step("получаем первый xKey из списка ")
    public String getFirstXkeyFromTable(){
        return table.getFirstValueFromChosenColomnTable(3);
    }

    @Step("получаем первый Name из списка ")
    public String getFirstNameFromTable(){
        return table.getFirstValueFromChosenColomnTable(2);
    }

    @Step("ищем значение по ключевому слову")
    public void searchByKeyword(String email) throws InterruptedException {
        filter.sendKeysForKeywordInput(email);
        spin.waitSmallSpinner();

    }

    @Step("берем весь текст из таблицы")
    public String getAllTextFromTable(){
       return table.getTableTrs();
    }


    /**
     *
     * @param block номер блока в фильтре справа
     * @param checkbox номер чекбокса в выбранном блоке
     * @return возвращает текст чекбокса, на которой кликает
     */

    @Step("кликаем на выбранный чекбокс")
    public void clickBychosenCheckbox(int block,int checkbox){
        spin.waitJquery();
        filter.clickChosenChebox(block,checkbox);
        spin.waitSmallSpinner();


    }

    @Step("проверяем что коммисия отфильтрованна")
    public void checkCommisionInTableContainsChosenCurrency(int block,int checkbox){

        String currency = filter.getTextChosenChebox(block,checkbox);
        this.checkCommisionContainsText(currency);

    }

    @Step("проверяем что выплаты отфильтрованны")
    public void checkPayoutInTableContainsChosenCurrency(String currency){
        checkPayoutContainsText(currency);

    }


    @Step("выбираем валюту выплат в хедере(наверху)")
    public String chooseTopCurrency(int num) {
        fheader.selectCurrency(num);
        spin.waitSmallSpinner();
        String text = fheader.getTextFromChosenCurrency(num);
        spin.waitSmallSpinner();
        return text;
    }


    @Step("кликаем на следующую страницу")
    public void clickNextPage(){
        table.clickNextPage();
        spin.waitSmallSpinner();
    }
}
