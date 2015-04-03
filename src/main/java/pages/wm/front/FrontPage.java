package pages.wm.front;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.WebElementHelper;
import pages.wm.front.elements.PopupLoginForm;
import roles.User;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import setup.ScreenshotHelper;

import java.io.IOException;

/**
 * Created by s.lugovskiy on 04.03.2015 10:59.
 */
public class FrontPage {

    private PopupLoginForm popupLoginForm;
    private WebElementHelper helper;
    private WebDriver driver;
    private final By headerXpath = By.xpath("//div[@class='header-menu']");

    public FrontPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        helper = new WebElementHelper(driver);
        this.driver = driver;
    }

    @Step("заполняем форму авторизации в попапе")
    public void login(User user){
        ((JavascriptExecutor) driver).executeScript("$('#popup-login-link').click();");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        popupLoginForm.fillLoginForm(user.getName(), user.getPassword());
        popupLoginForm.submitForm();
    }

    @Step
    public String saveHeaderScreen() throws Exception {
        return ScreenshotHelper.saveElementBitmap(driver, driver.findElement((headerXpath))).toString();
    }

    @Step
    public String takeHeaderScreen() throws Exception {
        return ScreenshotHelper.takeElementBitmap(driver, driver.findElement((headerXpath))).toString();
    }

    @Step
    public String getHeaderScreen() throws IOException {
        String headerScreen = ScreenshotHelper.openElementBitmap(headerXpath.toString());
        return headerScreen;
    }
}
