package wm.listener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import setup.Printer;
import setup.Utils;
import wm.login.BaseTest;

/**
 * Created by s.lugovskiy on 03.03.2015 13:56.
 */
public class AllureOnFailListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        Printer.println("========> TEST STARTED "+ result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Printer.println("========> TEST PASSED "+ result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Printer.println("========> TEST FAILED "+ result.getMethod().getMethodName());
        Printer.println("-------------------- Exception -------------------------------");
        Printer.println(result.getThrowable().getMessage());
        Printer.println("-------------------- Exception -------------------------------");
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).getDriver();
        Printer.println("CURRENT  URL: " + webDriver.getCurrentUrl());
        Utils utils = ((BaseTest) currentClass).getUtils();
        if (webDriver != null)
        {
            utils.takeScreenShoot();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Object currentClass = result.getInstance();
        Printer.println(" !!!!!!! TEST SKIPPED !!!!!!!!!! " + result.getMethod().getMethodName());
/*        WebDriver webDriver = ((BaseTest) currentClass).getDriver();
        Utils utils = ((BaseTest) currentClass).getUtils();
        if (webDriver != null)
        {
            utils.takeScreenShoot();
        }}*/
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Printer.println("========> TEST FAILED "+ result.getMethod().getMethodName());
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).getDriver();
        Utils utils = ((BaseTest) currentClass).getUtils();
        if (webDriver != null)
        {
            utils.takeScreenShoot();
        }
    }

    @Override
    public void onStart(ITestContext context) {
        Printer.println("--------> STARTED IN CONTEXT "+ context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        Printer.println("--------> FINISHED IN CONTEXT "+ context.getName());

    }
}
