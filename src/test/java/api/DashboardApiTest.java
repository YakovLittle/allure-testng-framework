package api;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.io.IOException;

import static org.testng.Assert.assertNotNull;

@Test
@Features("API")
public class DashboardApiTest{


    @Test
    @Stories("API запрос на сводную")
    @Severity(value = SeverityLevel.MINOR)
    public void apiDashboardTest() throws IOException {
        String token = System.getProperty("wmRemoteAuth");
        String url = "http://cityads.com/ru/json/dashboard/get?";
        String resp = Sender.get(url,token);
        assertNotNull(resp);
    }


}
