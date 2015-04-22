package pages.oauth.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by s.lugovskiy on 04.03.2015 11:15.
 */
@Name("OAuth form form")
@Block(@FindBy(xpath = "//div[@id='form']"))
public class OAuthForm extends HtmlElement {


    @Name("submit button")
    @FindBy(id="submit")
    private Button submit;

    @Name("login input")
    @FindBy(id="username")
    private TextInput loginInput;

    @Name("password input")
    @FindBy(id="password")
    private TextInput passwordInput;

    @Name("errors div")
    @FindBy(id="errors")
    private WebElement errors;

    @Name("errors div")
    @FindBy(xpath="//div[@class='footer']/a[@tabindex='8']")
    private Link forgotPasswd;

    @FindBy(xpath="//div[@class='footer']/a[@tabindex='9']")
    private Link newAccount;

    @Step("заполняею OAuth форму")
    public void fillForm(String login,String password){
        loginInput.clear();
        loginInput.sendKeys(login);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    @Step("отправляю OAuth форму")
    public void submitForm(){
        submit.click();
    }

    @Step
     public boolean isVisible(){
        return this.isDisplayed();
    }

    @Step
    public boolean isErrorVisible(){
        return errors.isDisplayed();
    }

    @Step
    @Attachment
    public String getErrorsText() {
        return errors.getText();
    }

    @Step
    public void clickForgotPassword() {
        forgotPasswd.click();
    }

    @Step
    public void clickNewAccountLink() {
        newAccount.click();
    }

    public WebElement getErrors() {
        return errors;
    }
}
