package pages.oauth;

import api.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.WebElementHelper;
import pages.oauth.elements.OAuthForm;
import roles.User;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import setup.Printer;

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
        Printer.println("login to oauth form: "+user);
        Printer.println("CURRENT URL "+driver.getCurrentUrl());
        helper.fluentWait(By.xpath("//div[@id='form']"));
        oAuthForm.fillForm(user.getName(),user.getPassword());
        oAuthForm.submitForm();
    }

    @Step("проверка что форма авторизации oauth видима")
    public void checkFormVisible(){
        Assertions.assertTrue(oAuthForm.isVisible());
    }

    @Step("проверка что форма авторизации oauth невидима")
    public void checkFormNotVisible(){
        Assertions.checkWebElementNotVisible(oAuthForm);
    }

    @Step("проверка что сообщение об ошибке присутствует")
    public void checkErrorVisible(){
        Assertions.checkWebElementVisible(oAuthForm.getErrors());
        //Assertions.assertTrue(oAuthForm.isErrorVisible());
    }


    @Step
    public void checkErrorText(String expectedText){
        String actualText = oAuthForm.getErrorsText();
        Assertions.assertObjectsEquals(expectedText,actualText);
    }


    @Step("Переход по ссылке Забыли пароль")
    public void goToForgotPassword() {
        oAuthForm.clickForgotPassword();
    }

    @Step("Переход по ссылке У меня нет аккаунта")
    public void goToNewAccount() {
        oAuthForm.clickNewAccountLink();
    }
}
