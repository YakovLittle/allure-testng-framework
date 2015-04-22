package pages.wm.front.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import setup.Printer;

/**
 * Created by s.lugovskiy on 04.03.2015 11:15.
 */
@Name("Popup login form")
@Block(@FindBy(xpath = "//div[@id='popup-login']"))
public class PopupLoginForm extends HtmlElement {


    @Name("enter button")
    @FindBy(xpath="//a[@id='popup-login-link' and ancestor::div[@class='link relative' and ancestor::li[@class='login']]]")
    private Link enter;

    @Name("login popup input")
    @FindBy(xpath = ".//div[@class='login']/input")
    private TextInput loginInput;

    @Name("password popup input")
    @FindBy(xpath = ".//div[contains(@class,'passwd')]/input[@type='password']")
    private TextInput passwordInput;

    @Name("submit")
    @FindBy(className = "submit")
    private WebElement submit;


    @Step("заполняем форму авторизации")
    public void fillLoginForm(String user,String password){
        loginInput.clear();
        loginInput.sendKeys(user);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        Printer.println("Current user: " + user);
    }

    @Step("отправляем форму")
    public void submitForm(){
        submit.click();
    }



}
