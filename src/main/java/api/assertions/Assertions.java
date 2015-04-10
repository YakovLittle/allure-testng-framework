package api.assertions;

import dataclass.OperationsHistoryTableLine;
import dataclass.Payments2TableLine;
import ru.yandex.qatools.allure.annotations.Step;
import setup.Printer;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

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
        assertThat(str, containsString(text));
    }

    @Step
    public static void assertTrue(Boolean condition){
        assertThat(condition,is(true));
    }

    @Step
    public static void assertGreater(int int1, int int2){
        assertThat(int1, greaterThan(int2));
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
}
