import Hooks.WebHooks;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static PageSteps.AuthorizationSteps.Authorization;
import static PageSteps.MainPageSteps.openProject;
import static PageSteps.ProjectPageSteps.*;
import static Utils.Configuration.getConfigurationValue;

public class Tests extends WebHooks {

    @Test
    @DisplayName("Авторизуемся на сайте")
    @Owner("Никита")
    public void Test1() {
        Authorization(getConfigurationValue("erUrl"));
    }

    @Test
    @DisplayName("Переходим в проект 'Test'")
    @Owner("Никита")
    public void Test2() {
        Authorization(getConfigurationValue("erUrl"));
        openProject();
    }

    @Test
    @DisplayName("Проверка общего количество задач в проекте")
    @Owner("Никита")
    public void Test3() {
        Authorization(getConfigurationValue("erUrl"));
        openProject();
        getTasksCount();
    }

    @Test
    @DisplayName("Переход и проверка в задачи")
    @Owner("Никита")
    public void Test4() {
        Authorization(getConfigurationValue("erUrl"));
        openProject();
        checkStatusAndVersion();
    }

    @Test
    @DisplayName("Создание нового бага с описанием")
    @Owner("Никита")
    public void Test5() {
        Authorization(getConfigurationValue("erUrl"));
        testSeleniumBug();

    }
}
//Добавил в каждый Step проверку assert.