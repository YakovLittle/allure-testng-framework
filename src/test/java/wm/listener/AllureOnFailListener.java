package wm.listener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import setup.Utils;
import wm.login.BaseTest;

/**
 * Created by s.lugovskiy on 03.03.2015 13:56.
 */
public class AllureOnFailListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {}

    @Override
    public void onTestSuccess(ITestResult result) {}

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).getDriver();
        Utils utils = ((BaseTest) currentClass).getUtils();
        if (webDriver != null)
        {
            utils.takeScreenShoot();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {        Object currentClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).getDriver();
        Utils utils = ((BaseTest) currentClass).getUtils();
        if (webDriver != null)
        {
            utils.takeScreenShoot();
        }}


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).getDriver();
        Utils utils = ((BaseTest) currentClass).getUtils();
        if (webDriver != null)
        {
            utils.takeScreenShoot();
        }
    }

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}
}
