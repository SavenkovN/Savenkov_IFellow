package steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

public class APITestMortySteps {
@Step("Найти информацию по персонажу Морти Смит")
    public static String morty() {
        Response response = given()
                .baseUri("baseUri")
                .queryParam("name", "Morty Smith")
                .when()
                .get("/character")
                .then()
                .statusCode(200)
                .extract().response();
        return response.getBody().asString();

    }
    @Step("Выбрать из ответа последний эпизод, где появлялся Морти")
    public static String episode(JSONObject mortyJO) {
        JSONArray episodesWithMorty = mortyJO.getJSONArray("episode");
        int episodeWithMorty = episodesWithMorty.length();
        String lastEpisode = episodesWithMorty.getString(episodeWithMorty - 1);
        Allure.addAttachment("Последний эпизод с Морти",
                lastEpisode.substring(lastEpisode.length() - 2));
        Response response1 = given()
                .contentType(ContentType.JSON)
                .get(lastEpisode)
                .then().extract().response();
        return response1.getBody().asString();
    }
    @Step("Получить из списка последнего эпизода последнего персонажа")
    public static String lastChar(JSONObject lastEpisode) {
        JSONArray allChars = lastEpisode.getJSONArray("characters");
        int charCount = allChars.length();
        String lastChar = allChars.getString(charCount - 1);
        Response response2 = given()
                .contentType(ContentType.JSON)
                .get(lastChar)
                .then().extract().response();
        return response2.getBody().asString();
    }
    @Step("Проверить, этот персонаж той же расы и находится там же где и Морти")
    public static void match(JSONObject charJson, JSONObject mortyJson) {
        String charName = charJson.getString("name");
        String charSpecies = charJson.getString("species");
        String charLocation = charJson.getJSONObject("location").getString("name");
        String Char = "\nПолное имя последнего персонажа "+charName+
                "\nРасса — "+charSpecies+ " " +
                "\nЛокация — " + charLocation;
        Allure.addAttachment("Информация о персонаже", Char);
        String mortyName = mortyJson.getString("name");
        String mortySpecies = mortyJson.getString("species");
        String mortyLocation = mortyJson.getJSONObject("location").getString("name");
        String morty =  "\nПолное имя главного персонажа — " +mortyName+ " " +
                "\nРасса — " +mortySpecies+
                "\nЛокация — " + mortyLocation;
        Allure.addAttachment("Информация о главном персонаже", morty);
        String compareResult = "";
        if(mortySpecies.equals(charSpecies)) {
            compareResult += "Расса " + mortyName + " + " + charName + " совпадают";
        } else compareResult += "Расса " + mortyName + " + " + charName + " не совпадают";
        if(mortyLocation.equals(charLocation)) {
            compareResult += "\nЛокация " + mortyName + " + " + charName + " совпадают";
        } else compareResult += "\nЛокация " + mortyName + " + " + charName + " не совпадают";
        Allure.addAttachment("Результат сравнения:", compareResult);
    }
}
