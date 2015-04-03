package api.assertions;

import ru.yandex.qatools.allure.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
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
        assertEquals(obj1,obj2);
    }

    @Step
    public static void assertTrue(Boolean condition){
        assertThat(condition,is(true));
    }

    @Step
    public static void assertGreater(int int1, int int2){
        assertThat(int1, greaterThan(int2));
    }

    @Step("проверяем что = 0")
    public static void assertEqualsNull(Float dashboardAdvHold) {
        assertFalse(dashboardAdvHold>0);
    }
}
