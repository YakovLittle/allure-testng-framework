package pages.mgr.finance.elements;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by a.hodakov on 12.03.2015.
 */
@Name("Finance Filter")
@Block(@FindBy(xpath = "//div[contains(@class,'filter-block')]"))
public class Filter extends HtmlElement{

    @FindBy(xpath=".//div[@class='input-icon-find']/div[@class='ember-view']/input[contains(@class,'ember-text-field')]")
    private TextInput keywordinput;



    @Step
    public void sendKeysForKeywordInput(String text) throws InterruptedException {
        keywordinput.clear();
        keywordinput.sendKeys(text);
        keywordinput.sendKeys(Keys.RETURN);
        Thread.sleep(1000);
    }


    @Step
    private WebElement getChosenCheckbox(int block,int checkbox){
        WebElement chosenchebox = findElement(By.xpath("((//div[@class='filter-item' and descendant::div[@class='filter-header']])[" + block + "]/div[@class='filter-content']/label)[" + checkbox + "]"));
        return chosenchebox;
    }



    /**
     *
     * @param block номер блока в фильтре справа
     * @param checkbox номер чекбокса в выбранном блоке
     * @return возвращает текст чекбокса, на которой кликает
     */

    @Attachment
    @Step
    public String getTextChosenChebox(int block,int checkbox){
        String text = this.getChosenCheckbox(block,checkbox).getText();
        return text;
    }


    @Step
    public void clickChosenChebox(int block,int checkbox){
        this.getChosenCheckbox(block,checkbox).click();
    }
}
