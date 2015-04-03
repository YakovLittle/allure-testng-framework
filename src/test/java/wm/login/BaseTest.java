package wm.login;


import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import setup.DriverSetup;
import setup.Printer;
import setup.Utils;

import java.lang.reflect.Method;

/**
 * Created by s.lugovskiy on 06.03.2015 10:41.
 */
public abstract class BaseTest {

    private WebDriver driver;
    private Utils utils;
    private DriverSetup setup;

    @BeforeClass
    public void init(){
        setup = new DriverSetup();
        driver = setup.getDriver();
        utils = new Utils(driver);
    }

    @BeforeMethod
    public void logMethodName(Method method){
        System.out.println();
        System.out.println();
        System.out.println("==================================================================");
        Printer.println("TEST STARTED: " + method.getName());
    }

    @AfterMethod
    public void logMethodNameAfter(Method method,ITestResult result){
        Printer.println(" TEST ENDED: " + method.getName());
        int start = ((int) result.getStartMillis());
        int end = ((int) result.getEndMillis());
        int diff = end-start;
        String name = result.getMethod().getMethodName();
        Printer.println(" "+name.toUpperCase()+" TEST DURATION: "+diff);
        System.out.println("==================================================================");
        System.out.println();
        System.out.println();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Utils getUtils() {
        return utils;
    }


}
