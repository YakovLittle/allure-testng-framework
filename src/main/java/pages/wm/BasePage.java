package pages.wm;


import api.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.WebElementHelper;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import setup.Printer;

/**
 * Created by s.lugovskiy on 06.03.2015 16:01.
 */
public class BasePage{

    private WebDriver driver;
    private String baseUrl;
    private String oauthStandUrl;
    private WebElementHelper helper;
    private Spinners spin;
    private Header header;
    private BlueTable blueTable;
    private Paginator paginator;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.baseUrl = System.getProperty("baseUrl");
        this.helper = new WebElementHelper(driver);
        this.oauthStandUrl = System.getProperty("oauthCity");
        this.spin = new Spinners(driver);
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public Object  evaluateJavascript(String script){
        return ((JavascriptExecutor)driver).executeScript(script);
    }

    @FindBy(xpath = "//h1")
    private WebElement h1;

    @Step
    public void goToSection(String url) {
        String testUrl = baseUrl + url;
        String newtestUrl = testUrl.replaceAll("//","/");
        driver.get(newtestUrl);
    }

    @Step
    public void goToAuthStandSection(String url) {
        String testUrl = oauthStandUrl + url;
        String newtestUrl = testUrl.replaceAll("//","/");
        Printer.println("GO TO "+newtestUrl);
        driver.get(newtestUrl);
    }

    @Step("проверка что хедер отображается")
    public void checkHeader(){
        Assertions.checkWebElementExists(header);
    }


    @Step("ждем загрузку сводных показателей")
    public void waitDashboard(){
        Printer.println("waiting for (//h2[contains(@class,'_overview_text')])[1]");
        helper.fluentWait(By.xpath("(//h2[contains(@class,'_overview_text')])[1]"));
    }

    @Step("Проверяем что данные совпадают")
    public void checkValuesAreEquals(Float i,Float j){
        Assert.assertEquals(i,j,"Холд в финансовой сводной "+i+" не совпадает с холдом в вкладке Начисления и выплаты "+j+"");
    }

    @Step("ожидание загрузки")
    public void waitSpinner(){
        spin.waitSpinner();
    }

    @Step("проверка наличия синей таблицы")
    public void checkTable() {
        Assertions.checkWebElementExists(blueTable);
    }

    @Step("проверка наличия пагинатора")
    public void checkpaginator(){
        Assertions.checkWebElementExists(paginator);
    }

    @Step
    public void checkH1(String s) {
        Assertions.checkWebElementHasText(h1,s);
    }

    @Step("ожидание загрузки страницы менеджера")
    public void waitMgrPage(){
        helper.fluentWait(By.xpath("//div[@class='page']"));
    }

    @Step("ожидание загрузки таблицы")
    public void waitTable() {
        helper.fluentWait(By.xpath("//table[contains(@class,'blue_table')]"));
    }
}
