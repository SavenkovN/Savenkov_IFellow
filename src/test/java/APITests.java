import hooks.APIHooks;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static steps.APITestMortySteps.*;
import static steps.APITestTomato.*;

public class APITests extends APIHooks {
    @Test
    @DisplayName("Вытаскиваем данные и сравниваем их")
    public void mortyy() {

        JSONObject mortyJson = new JSONObject(morty());
        JSONObject episodeJson = new JSONObject(episode(mortyJson));
        JSONObject characterJson = new JSONObject(lastChar(episodeJson));
        match(characterJson, mortyJson);
    }
    @Test
    @Tag("APITests")
    @DisplayName("Создаем тест запрос и делаем проверку")
    public void potato() throws IOException {

        JSONObject jsonObject = getJO("potato.json");
        putJO(jsonObject, "name", "Tomato", "job", "Eat maket");
        JSONObject responseJO = inOutJO(jsonObject, "https://reqres.in/");
        assertJO(responseJO);
    }
}
