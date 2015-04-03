/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s.lugovskiy
 */
public class DriverSetup {
    private static String remoteUrl = System.getProperty("remoteUrl");


    @Step("инициализация драйвера")
    @Attachment
    public WebDriver getDriver(){
        WebDriver driver = null;
        String browser = System.getProperty("driver");
        DesiredCapabilities capabilities;
        switch (browser) {
            case "phantomjs":
                capabilities = DesiredCapabilities.phantomjs();
                break;
            case "chrome":
                capabilities = DesiredCapabilities.chrome();
                break;
            default:
                capabilities = DesiredCapabilities.firefox();
                break;
        }
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.SEVERE);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        try {
            driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);

        } catch (MalformedURLException ex) {
            Logger.getLogger(DriverSetup.class.getName()).log(Level.SEVERE, null, ex);
        }
        Printer.println("Creating driver instance: "+" "+capabilities.getBrowserName() +" "+capabilities.getVersion()+" "+capabilities.getPlatform());
        return driver;
    }

}
