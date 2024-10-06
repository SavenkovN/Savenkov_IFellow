package steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static hooks.APIHooks.getJson;
import static io.restassured.RestAssured.given;

public class APITestTomato {

    @Step("Берем JSONObject")
    public static JSONObject getJO(String fileName) throws IOException {
        getJson(fileName);
        return new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/" + fileName))));
    }

    @Step("Ставим Ключ/Значение")
    public static JSONObject putJO(JSONObject jsonObject, String key1, Object value1, String key2, Object value2) {
        jsonObject.put(key1, value1);
        jsonObject.put(key2, value2);
        return jsonObject;
    }

    @Step("Отправляем запрос и вызываем ответ")
    public static JSONObject inOutJO(JSONObject jsonObject, String url) {
        Response response = given()
                .baseUri(url)
                .contentType("application/json;charset=UTF-8")
                .log().all()
                .when()
                .body(jsonObject.toString())
                .post("/api/users")
                .then()
                .statusCode(201)
                .log().all()
                .extract().response();

        String tomato = response.getBody().asString();
        return (new JSONObject(tomato));
    }

    @Step("Делаем проверку")
    public static void assertJO(JSONObject jsonObject) {
        String result;
        if (jsonObject.getString("name").equals("Tomato")
                && jsonObject.getString("job").equals("Eat maket")) {
            result = "Проверка пройдена";
        } else result = "Проверка не пройдена";
        Allure.addAttachment("Результат проверки: ", result);
    }
}