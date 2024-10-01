import hooks.APIHooks;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static steps.APITestMortySteps.*;

public class APITests extends APIHooks {
    @Test
    @DisplayName("Вытаскиваем данные и сравниваем их")
    public void mortyy() {

        JSONObject mortyJson = new JSONObject(morty());
        JSONObject episodeJson = new JSONObject(episode(mortyJson));
        JSONObject characterJson = new JSONObject(lastChar(episodeJson));
        match(characterJson, mortyJson);
    }
}