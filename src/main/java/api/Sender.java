package api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import setup.Printer;

import java.io.IOException;

/**
 * Created by s.lugovskiy on 13.03.2015 13:06.
 */
public class Sender {


    /**
     *
     * @param url полная ссылка на заправшиваемый ресурс
     * @param token значение гет-параметра remote_auth пользовалтеля
     * @return возвращает тело ответа в виде строки
     * @throws IOException
     */
    @Step
    @Attachment
    public static String get(String url,String token) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        String urlNew = url+"remote_auth="+token;
        Printer.println("GET: " + urlNew);
        HttpGet httpGet = new HttpGet(urlNew);
        HttpResponse response = httpclient.execute(httpGet);
        String res = EntityUtils.toString(response.getEntity());
        return res;
    }


    @Step
    @Attachment
    public static String get(String url) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        Printer.println("GET: "+url);
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpclient.execute(httpGet);
        String res = EntityUtils.toString(response.getEntity());
        return res;
    }

}
