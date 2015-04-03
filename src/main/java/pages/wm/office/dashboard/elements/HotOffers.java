package pages.wm.office.dashboard.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * Created by s.lugovskiy on 04.03.2015 11:15.
 */
@Name("Топовые предложения")
@Block(@FindBy(xpath = "(//div[@class='span3']/div)[1]"))
public class HotOffers extends HtmlElement {

    @FindBy(xpath = "(//div[@class='_slide_switcher left']/div)[1]")
    private WebElement firstSwitch;

    @FindBy(xpath = "//div[@id='hotOffersSlider']/div/div[@class='_item']/div[@class='offer-card']/div[@class='offer-card-name']/a")
    private Link topOffer;

    @Step("клик по первому переключателю в слайдере")
    public void clickFirstSwitch(){
        firstSwitch.click();
    }

    @Step("клик по первому офферу в слайдере топ предложения")
    public void clickTopOffer(){
        topOffer.click();
    }


}
