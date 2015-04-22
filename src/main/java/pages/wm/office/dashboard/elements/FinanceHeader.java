package pages.wm.office.dashboard.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@Name("Финансовый хедер")
@Block(@FindBy(xpath = "((//div[contains(@class,'header-right')]/div[contains(@class,'text-right')]/div)[4]/div)[1]"))
public class FinanceHeader extends HtmlElement {

    @FindBy(xpath = "(//span[contains(@class,'_header_balance')])[1]")
    private WebElement open;

    @FindBy(xpath = "(//span[contains(@class,'_header_balance')])[2]")
    private WebElement aproved;

    @FindBy(xpath = "(//span[contains(@class,'_header_balance')])[3]")
    private WebElement available;

    public Float getOpen() {
        return Float.valueOf(open.getText().trim().replace("\'","").replace("/",""));
    }

    public Float getAproved() {
        return Float.valueOf(aproved.getText().trim().replace("\'", "").replace("/", ""));
    }

    public Float getAvailable() {
        return Float.valueOf(available.getText().trim().replace("\'", "").replace("/", ""));
    }
}
