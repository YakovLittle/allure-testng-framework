package pages.wm;

import com.google.common.base.Predicate;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import setup.Printer;

import java.util.concurrent.TimeUnit;


/**
 * Created by s.lugovskiy on 06.03.2015 13:14.
 */
public class Spinners extends HtmlElement{

    private WebDriver driver;

    public Spinners(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
    }

    private boolean checkOpacitySpinnerJquery(){
        boolean check;
        check = tableIsReady() && chartIsReady() && deltachartIsReady();
        return check;
    }

    private boolean checkSpinnerJquery(){
        boolean check = false;
        Long spinner;
        spinner = (Long)((JavascriptExecutor)driver).executeScript("return $('.spinner-icon').length");
        if(spinner == 0){check = false;}
        else {check = true;}
        return check;

    }

    private boolean checkJqueryIsActive(){
        Boolean animation;
        animation = (Boolean)((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
        return animation;
    }

    private boolean checkDynamicSpinnerIsNotActive(){
        Boolean animation;
        animation = (Boolean)((JavascriptExecutor)driver).executeScript("return $('div[class=\"dynamics\"]').size() == 0");
        return animation;
    }

    //$('div[class="dynamics"]').size()

    private boolean tableIsReady(){
        boolean contextCheck = true;
        boolean cityCheck = true;
        boolean check = true;
        contextCheck = (Boolean)((JavascriptExecutor)driver).executeScript("return CityAds.context.current==null");
        cityCheck = (Boolean)((JavascriptExecutor)driver).executeScript("return typeof(CityAds) == 'undefined'");
        if(!contextCheck && !cityCheck){
            check =  (Boolean)((JavascriptExecutor)driver).executeScript("return typeof (CityAds.context.current.requesterInterface.requesters.table) == 'undefined';");
            if(!check){
                try {
                    int requestId = ((Long) this.evaluateJavascript("return CityAds.context.current.requesterInterface.requesters.table.req_id[0]")).intValue();
                    Printer.println("-------->>>>   Request ID = " + requestId);
                }
                catch(Exception e) {
                }
            }
        }
        Printer.println("table ready at "+ driver.getCurrentUrl() +" "+check);
        return check;

    }

    private boolean mapIsReady(){
        boolean contextCheck = true;
        boolean check = true;
        contextCheck = (Boolean)((JavascriptExecutor)driver).executeScript("return CityAds.context.current==null");
        if(!contextCheck){
            check =  (Boolean)((JavascriptExecutor)driver).executeScript("return typeof (CityAds.context.current.requesterInterface.requesters.map) == 'undefined';");
            if(!check){
                try {
                    int requestId = ((Long) this.evaluateJavascript("return CityAds.context.current.requesterInterface.requesters.map.req_id[0]")).intValue();
                    Printer.println("-------->>>>   Request ID = " + requestId);
                }
                catch(Exception e) {
                }
            }
        }
        Printer.println("map ready: "+check);
        return check;
    }

    private boolean chartIsReady(){
        boolean contextCheck = true;
        boolean check = true;
        contextCheck = (Boolean)((JavascriptExecutor)driver).executeScript("return CityAds.context.current==null");
        if(!contextCheck){
            check =  (Boolean)((JavascriptExecutor)driver).executeScript("return typeof (CityAds.context.current.requesterInterface.requesters.chart) == 'undefined';");
            if(!check){
                try {
                    int requestId = ((Long) this.evaluateJavascript("return CityAds.context.current.requesterInterface.requesters.chart.req_id[0]")).intValue();
                    Printer.println("-------->>>>   Request ID = " + requestId);
                }
                catch(Exception e) {
                }
            }
        }
        Printer.println("chart ready: at "+ driver.getCurrentUrl() +" "+check);
        return check;
    }

    private boolean deltachartIsReady(){
        boolean contextCheck = true;
        boolean check = true;
        contextCheck = (Boolean)((JavascriptExecutor)driver).executeScript("return CityAds.context.current==null");
        if(!contextCheck){
            check =  (Boolean)((JavascriptExecutor)driver).executeScript("return typeof (CityAds.context.current.requesterInterface.requesters.delta_chart) == 'undefined';");
            if(!check){
                try {
                    int requestId = ((Long) this.evaluateJavascript("return CityAds.context.current.requesterInterface.requesters.delta_chart.req_id[0]")).intValue();
                    Printer.println("-------->>>>   Request ID = " + requestId);
                }
                catch(Exception e) {
                }
            }
        }
        Printer.println("delta chart ready: at "+ driver.getCurrentUrl() +" "+check);
        return check;
    }
    
    private Object  evaluateJavascript(String script){
        return ((JavascriptExecutor)driver).executeScript(script);
    }

    public void waitSpinner(){
        new FluentWait<WebDriver>(driver).
                withTimeout(60, TimeUnit.SECONDS).
                pollingEvery(1000, TimeUnit.MILLISECONDS).
                ignoring(NoSuchElementException.class).
                until(new Predicate<WebDriver>(){
                    public boolean apply(WebDriver driver){
                        Printer.println("small spinner at "+ driver.getCurrentUrl() +" ready: "+!checkSpinnerJquery());
                        return !checkSpinnerJquery();
                    }
                });


        new FluentWait<WebDriver>(driver).
                withTimeout(120, TimeUnit.SECONDS).
                pollingEvery(1000, TimeUnit.MILLISECONDS).
                ignoring(NoSuchElementException.class).
                until(new Predicate<WebDriver>(){
                    public boolean apply(WebDriver driver){
                        return checkOpacitySpinnerJquery();
                    }
                });
        //this.waitJquery();
    }

    @Step("ждем исчезновения маленькой крутилки наверху")
    public void waitSmallSpinner(){
        this.waitJquery();
        new FluentWait<WebDriver>(driver).
                withTimeout(60, TimeUnit.SECONDS).
                pollingEvery(1000, TimeUnit.MILLISECONDS).
                ignoring(NoSuchElementException.class).
                until(new Predicate<WebDriver>(){
                    public boolean apply(WebDriver driver){
                        Printer.println("small spinner at "+ driver.getCurrentUrl() +" ready: "+!checkSpinnerJquery());
                        return !checkSpinnerJquery();
                    }
                })
        ;
        this.waitJquery();
    }

    @Step("ожидание выполнения анимации JQuery")
    public void waitJquery(){
        new FluentWait<WebDriver>(driver).
                withTimeout(60, TimeUnit.SECONDS).
                pollingEvery(1000, TimeUnit.MILLISECONDS).
                   until(new Predicate<WebDriver>() {
                       public boolean apply(WebDriver driver) {
                           Printer.println("wait for jQuery.active == 0  ---> " + checkJqueryIsActive());
                           return checkJqueryIsActive();
                       }
                   });
    }

    @Step("ожидание выполнения анимации крутилок динамики")
    public void waitDynamics(){
        new FluentWait<WebDriver>(driver).
                withTimeout(30, TimeUnit.SECONDS).
                pollingEvery(1000, TimeUnit.MILLISECONDS).
                until(new Predicate<WebDriver>() {
                    public boolean apply(WebDriver driver) {
                        Printer.println("wait for $('div[class=\"dynamics\"]').size() == 0  ---> " + checkDynamicSpinnerIsNotActive());
                        return checkDynamicSpinnerIsNotActive();
                    }
                });
    }
}
