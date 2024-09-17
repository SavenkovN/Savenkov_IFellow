package PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import java.time.Duration;
import static PageObject.PageElements.ProjectPage.*;
import static com.codeborne.selenide.Selenide.sleep;

public class ProjectPageSteps {

    @Step("Подсчет общего количества задач")
    public static void getTasksCount() {
        String count = pagesCountElem.getOwnText();
        System.out.println("Мы имеем " + count.split(" ")[2] + " задач.");
        Assertions.assertNotNull(count);
    }

    @Step("Проверить статус и версию")
    public static void checkStatusAndVersion() {
        allTasksAndFilters.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        inputNameTask.shouldBe(Condition.visible, Duration.ofSeconds(10)).sendKeys("TestSeleniumATHomework");
        searchButton.click();
        selectNeedTask.click();
        assertStatus.shouldHave(Condition.text("Сделать"), Duration.ofSeconds(10));
        assertVersion.shouldHave(Condition.text("Version 2.0"), Duration.ofSeconds(10));
        Assertions.assertEquals(assertStatus.getText(), "СДЕЛАТЬ");
        Assertions.assertEquals(assertVersion.getText(), "Version 2.0");
    }

    @Step("Создать баг и перевод его статуса")
    public static void testSeleniumBug() {
        createLink.click();
        typeTask.click();
        typeTask.sendKeys(Keys.DELETE);
        typeTask.shouldBe(Condition.visible).setValue("О");
        typeTask.pressEnter();
        themeTask.click();
        themeTask.sendKeys("Создание бага");
        descriptionTextButton.click();
        textAreaDescription.sendKeys("New");
        versionAreaDescription.click();
        propertyTask.click();
        labelTask.click();
        labelTask.sendKeys("Sav_B");
        labelTask.pressEnter();
        textEnvironment.sendKeys("1");
        sunkVersion.click();
        sleep(2000);
        task.sendKeys("TEST-121056");
        task.pressEnter();
        sleep(2000);
        create.click();
        myTask.click();
        statusInWork.click();
        sleep(2000);
        businessProcess.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        sleep(2000);
        statusWin.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        getAssertStatusMyTask.shouldHave(Condition.text("Готово"));
        sleep(2000);
        Assertions.assertEquals(getAssertStatusMyTask.getText(), "ГОТОВО");
    }
}
