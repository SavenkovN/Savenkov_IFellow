package PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import static PageObject.PageElements.MainPage.*;

public class MainPageSteps {

    @Step("Заходим в проект")
    public static void openProject(){
        projectsMenuButton.shouldBe(Condition.visible).click();
        projectTestLink.shouldBe(Condition.visible).click();
        Assertions.assertEquals(assertOpenTasks.getText(), "Открытые задачи");
    }


}
