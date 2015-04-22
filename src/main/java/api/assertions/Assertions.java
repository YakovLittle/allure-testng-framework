package api.assertions;

import dataclass.OperationsHistoryTableLine;
import dataclass.Payments2TableLine;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import ru.yandex.qatools.htmlelements.matchers.DoesElementExistMatcher;
import ru.yandex.qatools.htmlelements.matchers.IsElementDisplayedMatcher;
import ru.yandex.qatools.htmlelements.matchers.WebElementMatchers;
import setup.Printer;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.not;
import static org.testng.Assert.assertEquals;



/**
 * Created by s.lugovskiy on 20.03.2015 14:40.
 */
public class Assertions {

    @Step
    public static void assertObjectsEquals(Object obj1,Object obj2){
        Printer.println(obj1 + " equals ? " + obj2);
        assertEquals(obj1,obj2);
    }

    @Step
    public static void assertStringContains(String str, String text){
        org.hamcrest.MatcherAssert.assertThat(str, org.hamcrest.Matchers.containsString(text));
    }

    @Step
    public static void assertTrue(Boolean condition){
        Assert.assertTrue(condition);
    }

    @Step
    public static void assertFalse(Boolean condition){
        Assert.assertFalse(condition);
    }

    @Step
    public static void assertGreater(int int1, int int2){
        assertTrue(int1>int2);
    }

    @Step
    public static void assertGreaterOrEquals(float f1, float f2){
        assertTrue(f1>=f2);
    }

    @Step("проверяем что = 0")
    public static void assertEqualsNull(Float dashboardAdvHold) {
        assertFalse(dashboardAdvHold>0);
    }

    @Step("Проверяем что размер и содержимое списков Истории операций одинаковы")
    public static void listsEquals(ArrayList<OperationsHistoryTableLine> list, ArrayList<OperationsHistoryTableLine> list2) {
        int size1 = list.size();
        int size2 = list.size();
        //assertObjectsEquals(size1,size2);
        int j;
        for(j=0;j<size1;j++){
            if(!list.get(j).equals(null)) {
                if(!list2.get(j).equals(null)){
                    assertObjectsEquals(list.get(j),list2.get(j));
                }
            }
        }
    }

    @Step
    public static void checkPayments2List(ArrayList<Payments2TableLine> list) {
        for(Payments2TableLine line : list){
            line.checkColumns();
        }
    }

    @Step
    public static void checkWebElementExists(WebElement elem){
        org.hamcrest.MatcherAssert.assertThat(elem, ru.yandex.qatools.htmlelements.matchers.DoesElementExistMatcher.exists());
    }

    @Step
    public static void checkWebElementExists(HtmlElement elem){
        org.hamcrest.MatcherAssert.assertThat(elem, ru.yandex.qatools.htmlelements.matchers.DoesElementExistMatcher.exists());
    }

    @Step
    public static void checkWebElementHasText(WebElement elem, String text){
        org.hamcrest.MatcherAssert.assertThat(elem, WebElementMatchers.hasText(text));
    }

    @Step
    public static void checkWebElementExists(TypifiedElement elem){
        org.hamcrest.MatcherAssert.assertThat(elem.getWrappedElement(), ru.yandex.qatools.htmlelements.matchers.DoesElementExistMatcher.exists());
    }

    @Step
    public static void checkWebElementVisible(WebElement elem){
        org.hamcrest.MatcherAssert.assertThat(elem, ru.yandex.qatools.htmlelements.matchers.IsElementDisplayedMatcher.isDisplayed());
    }

    @Step
    public static void checkWebElementVisible(HtmlElement elem){
        org.hamcrest.MatcherAssert.assertThat(elem, IsElementDisplayedMatcher.isDisplayed());
    }

    @Step
    public static void checkWebElementVisible(TypifiedElement elem){
        org.hamcrest.MatcherAssert.assertThat(elem.getWrappedElement(), ru.yandex.qatools.htmlelements.matchers.IsElementDisplayedMatcher.isDisplayed());
    }

    @Step
    public static void checkWebElementNotVisible(HtmlElement elem) {
        org.hamcrest.MatcherAssert.assertThat(elem.getWrappedElement(), not(DoesElementExistMatcher.exists()));
    }
}
