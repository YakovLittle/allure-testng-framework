package pages.oauth.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
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



}
