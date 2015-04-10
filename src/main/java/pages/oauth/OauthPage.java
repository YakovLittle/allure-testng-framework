package pages.oauth;

import org.openqa.selenium.WebDriver;
import pages.WebElementHelper;
import pages.oauth.elements.OAuthForm;
import roles.User;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by s.lugovskiy on 04.03.2015 10:59.
 */
public class OauthPage {


    private WebElementHelper helper;
    private WebDriver driver;
    private OAuthForm oAuthForm;

    public OauthPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        helper = new WebElementHelper(driver);
        this.driver = driver;
    }

    @Step
    public void oauthLogin(User user){
        oAuthForm.fillForm(user.getName(),user.getPassword());
        oAuthForm.submitForm();
    }




}
