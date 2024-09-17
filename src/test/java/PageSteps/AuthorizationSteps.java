package PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import static PageObject.PageElements.AuthorizationPage.*;
import static com.codeborne.selenide.Selenide.open;
import static Utils.Configuration.getConfigurationValue;

public class AuthorizationSteps {

    @Step("Проведем авторизацию {erUrl}")
    public static void Authorization(String erUrl) {
        open(erUrl);
        loginLane.shouldBe(Condition.visible).sendKeys(getConfigurationValue("adminLogin"));
        passwordLane.sendKeys(getConfigurationValue("password"));
        loginButton.click();
        welcome.shouldHave(Condition.text("Добро пожаловать в Jira"));
        Assertions.assertEquals(welcome.getText(), "Добро пожаловать в Jira");
    }
}
