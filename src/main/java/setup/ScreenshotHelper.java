package setup;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.Augmenter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by s.lugovskiy on 03.04.2015 9:55.
 */
public class ScreenshotHelper {

    @Step
    @Attachment
    public static File saveElementBitmap(WebDriver driver, WebElement element) throws Exception {
        // Делаем скриншот страницы
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screen = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        // Создаем экземпляр BufferedImage для работы с изображением
        BufferedImage img = ImageIO.read(screen);

        // Получаем размеры элемента
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        // Создаем прямоуголник (Rectangle) с размерами элемента
        Rectangle rect = new Rectangle(width, height);
        // Получаем координаты элемента
        Point p = element.getLocation();
        // Вырезаем изображенеи элемента из общего изображения
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);

        // Перезаписываем File screen
        ImageIO.write(dest, "png", screen);
        imageToByteWrapper(screen);
        // Возвращаем File c изображением элемента


        System.out.println(element.toString());
        String stripperName = element.toString().split("->")[1].replaceAll(":","").replaceAll("/","").replace("]]","]").trim();
        String nameScreenshot = getFileName(stripperName);

        String path = getPath(nameScreenshot);
        System.out.println("PATH: "+path);
        File newScreen = new File(path);
        FileUtils.copyFile(screen, newScreen);
        Printer.println(String.valueOf(newScreen));
        return newScreen;
    }

    @Step
    @Attachment
    public static File takeElementBitmap(WebDriver driver, WebElement element) throws Exception {
        // Делаем скриншот страницы
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screen = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        // Создаем экземпляр BufferedImage для работы с изображением
        BufferedImage img = ImageIO.read(screen);
        // Получаем размеры элемента
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        // Создаем прямоуголник (Rectangle) с размерами элемента
        Rectangle rect = new Rectangle(width, height);
        // Получаем координаты элемента
        Point p = element.getLocation();
        // Вырезаем изображенеи элемента из общего изображения
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
        // Перезаписываем File screen
        ImageIO.write(dest, "png", screen);
        imageToByteWrapper(screen);
        // Возвращаем File c изображением элемента
        return screen;
    }

    private static String getFileName(String nameTest) {
        return nameTest;
    }

    private static String getPath(String name) throws IOException {
        File directory = new File(".");
        System.out.println("PATH: "+directory.getCanonicalPath() +"/src/main/resources/screenshots/" + getFileName(name));
        return directory.getCanonicalPath() +"/src/main/resources/screenshots/" + getFileName(name);
    }

    @Step
    @Attachment(value = "webelement screenshot", type = "image/png")
    public static byte[] imageToByteWrapper(File screenshot) throws IOException {
        BufferedImage bImage = ImageIO.read(screenshot);
        byte[] imageInByteArray;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "png", baos);
        imageInByteArray = baos.toByteArray();
        baos.flush();
        return imageInByteArray;
    }

    @Step
    @Attachment
    public static String openElementBitmap(String name) throws IOException {
        String path = getPath(name).replace("By.","").replace("xpath:","xpath").replace("//","").trim();
        File newScreen = new File(path);
        System.out.println("PATH: "+newScreen.getAbsolutePath());
        imageToByteWrapper(newScreen);
        return  newScreen.toString();
    }
}
