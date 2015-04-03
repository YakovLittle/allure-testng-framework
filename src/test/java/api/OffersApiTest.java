package api;

import api.assertions.Assertions;
import com.google.gson.internal.LinkedTreeMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import wm.login.BaseTest;

import java.io.IOException;

@Test
@Features("API")
public class OffersApiTest extends BaseTest {

    private String url;
    private String token;
    private String json;
    private JsonParser parser;


    @BeforeClass
    public void init(){
        String baseUrl = System.getProperty("baseUrl");
        token = System.getProperty("wmRemoteAuth");
        url = baseUrl+"api/rest/webmaster/json/offers/web?";
        try {
            json = Sender.get(url,token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        parser = new JsonParser(json);

    }

    @Test
    @Stories("json/offers status")
    @Severity(value = SeverityLevel.CRITICAL)
    public void offersStatusTest() throws IOException {

        int status = parser.getStatus();
        Assertions.assertObjectsEquals(status,200);

    }

    @Test
    @Stories("json/offers items")
    @Severity(value = SeverityLevel.NORMAL)
    public void offersItemsTest() throws IOException {

        LinkedTreeMap items = parser.getItems();
        Assertions.assertGreater(items.size(),10);

    }

}
