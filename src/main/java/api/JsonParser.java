package api;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by s.lugovskiy on 20.03.2015 11:44.
 */
public class JsonParser {

    private LinkedTreeMap root;

    public JsonParser(String json) {
        root = parse(json);
    }

    @Step
    @Attachment
    private  LinkedTreeMap parse(String json){
        try {
            Gson gson = new Gson();
            return (LinkedTreeMap) gson.fromJson(json, Object.class);
        }
        catch(JsonSyntaxException ex){
            System.out.println("Can not parse json: "+json);
            ex.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param nodeName     имя нода в json
     * @return возвращает значение нода
     */
    @Step
    @Attachment
    private Object getNode(String nodeName){
        return root.get(nodeName);
    }

    /**
     *
     * @param node json нод в котором ищем вложенный нод
     * @param nodeName имя искомого нода
     * @return возвращает json нод
     */
    @Step
    @Attachment
    private Object getSubNode(LinkedTreeMap node, String nodeName){
        return node.get(nodeName);
    }

    /**
     *
     * @return статус всегда целое число
     */
    @Step("Получаем значение поля status в json")
    @Attachment
    public int getStatus(){
        Double status = (Double) getNode("status");
        return status.intValue();
    }

    @Step("Получаем data->items в json")
    @Attachment
    public LinkedTreeMap getItems(){
        LinkedTreeMap data = (LinkedTreeMap)getNode("data");
        LinkedTreeMap items = (LinkedTreeMap)getSubNode(data,"items");
        return items;
    }


}
