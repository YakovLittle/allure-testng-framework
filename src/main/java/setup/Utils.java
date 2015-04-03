package setup;

import dataclass.FinanceSummary;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.Augmenter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;




public class Utils {

    public WebDriver driver;
    public Utils(WebDriver driver) {
        this.driver = driver;
    }



    @Attachment(value = "screenshot", type = "image/png")
    public byte[] takeScreenShoot() {
        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
            String nameScreenshot = getFileName(DataGenerator.getRandomNameWithDate());
            String path = getPath(nameScreenshot);
            File newScreen = new File(path);
            FileUtils.copyFile(screenshot, newScreen);
            Printer.println(String.valueOf(newScreen));

            BufferedImage bImage = ImageIO.read(screenshot);
            byte[] imageInByteArray;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "png", baos);
            imageInByteArray = baos.toByteArray();
            baos.flush();

            return imageInByteArray;
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void close() {
        String curUrl = driver.getCurrentUrl();
        driver.quit();
    }

    @Step("переход на главную страницу приложения")
    @Attachment
    public String openMainPage(){
        String host = System.getProperty("baseUrl");
        driver.get(host);
        Printer.println("Go to "+host);
        driver.manage().window().maximize();
        return driver.getCurrentUrl();
    }

    private static String getFileName(String nameTest) {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
        Date date = new Date();
        return dateFormat.format(date) + "_" + nameTest + ".png";
    }

    private static String getPath(String nameTest) throws IOException {
        File directory = new File(".");
        return directory.getCanonicalPath() + "/target/allure-results/" + getFileName(nameTest);
    }

    @Step("Проверяем логи консоли браузера")
    public void checkConsoleLog(){
        List<String> l = get_all_logs();
        check_array_has_errors(l);

    }

    @Step
    public List<String> get_all_logs(){
        List<String> l = new ArrayList<String>();
        Logs logs = driver.manage().logs();
        LogEntries logEntries = logs.get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            Printer.println("Console output: "+logEntry.getMessage());
            l.add(logEntry.getMessage());
        }
        return l;
    }

    @Step
    public void check_array_has_errors(List<String> list){
        assertFalse(list.size() > 0,"Проверяем что в логах консоли нет сообщений уровня SEVERE " + list);
    }

    @Step("Сравниваем данные с финансовой сводной и из раздела Начисления")
    public void compareFinanceSummary(FinanceSummary summary1,FinanceSummary summary2){
        assertEquals(summary1,summary2);
    }

    @Step("Возращаемся на предыдущую страницу ")
    public void goBack() throws InterruptedException {
        Printer.println("Go back");
        driver.navigate().back();
        Thread.sleep(1500);
    }

    @Step
    public void checkStringContainsString(String str, String text){
        assertThat(str, containsString(text));
    }
    @Step
    public void checkStringNotContainsString(String str, String text){
        assertThat(str, not(containsString(text)));
    }

    @Step("Переходим в режим отладки по ссылке http://cityadspix.com/monitor/api/cnt-cookie-set?mode=xml")
    public void setDebugCookie() {
          driver.get("http://cityadspix.com/monitor/api/cnt-cookie-set?mode=xml");
    }

    @Step
    public void openUrl(String url) {
        driver.get(url);
    }


    @Step
    @Attachment
    public String getClickId(String txt){
        String re1="(\\d+)";	// Integer Number 1
        String re2="(-)";	// Any Single Character 1
        String re3="(\\d+)";	// Integer Number 2
        String re4="(-)";	// Any Single Character 2
        String re5="(\\d+)";	// Integer Number 3
        String re6="(-)";	// Any Single Character 3
        String re7="(\\d+)";	// Integer Number 4

        Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
        {
            String int1=m.group(1);
            String c1=m.group(2);
            String int2=m.group(3);
            String c2=m.group(4);
            String int3=m.group(5);
            String c3=m.group(6);
            String int4=m.group(7);
            String clickId = (int1.toString()+c1.toString()+int2.toString()+c2.toString()+int3.toString()+c3.toString()+int4.toString());
            return clickId;
        }
        else return null;
    }

    @Step
    @Attachment
    public String getFinalUrl(String txt){

        String re1="((?:http|https)(?::\\/{2}[\\w]+)(?:[\\/|\\.]?)(?:[^\\s\"]*))";	// HTTP URL 1
        Pattern p = Pattern.compile(re1,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        String finalUrl = null;
        while (m.find())
        {
            String httpurl1 = m.group(1);
            finalUrl = (httpurl1.toString());
        }
        return finalUrl.split("<")[0];
    }

    @Step
    public String getDp(String url){
        return url.split("dp=")[1].split("_tp")[0];
    }

    @Step
    public void checkStringEquals(String clickId, String clickId2) {
        assertEquals(clickId, clickId2);
    }
}


