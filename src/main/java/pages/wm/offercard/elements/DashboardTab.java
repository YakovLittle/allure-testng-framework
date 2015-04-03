package pages.wm.offercard.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by s.lugovskiy on 06.03.2015 16:50.
 */

@Name("Offer card dashboard")
@Block(@FindBy(xpath = "//div[contains(@class,'list-pages') and @tab='detail_offer']"))
public class DashboardTab extends HtmlElement{

    public boolean isOnOfferCard(){
        return this.isDisplayed();
    }
}
