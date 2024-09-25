package StepDefinitions;

import io.cucumber.java.ru.*;
import static PageSteps.AuthorizationSteps.Authorization;
import static PageSteps.MainPageSteps.openProject;
import static PageSteps.ProjectPageSteps.*;
import static Utils.Configuration.getConfigurationValue;

public class StepDefinitions {
    @Дано("я открываю сайт {string}")
    public void яОткрываюСайт(String url) {
        Authorization(getConfigurationValue(url));
    }

    @Когда("я авторизуюсь на сайте")
    public void яАвторизуюсьНаСайте() {
        Authorization(getConfigurationValue("erUrl"));
    }
    @Тогда("я перехожу в проекты")
    public void яПерехожуВПроект() {
        openProject();
    }
    @И("я проверяю общее количество задач")
    public void яПроверяюОбщееКоличествоЗадач() {
        getTasksCount();
    }
    @Тогда("я проверяю статус и версию задачи")
    public void яПроверяюСтатусИВерсиюЗадачи() {
        checkStatusAndVersion();
    }
    @То("я создаю новый баг с описанием")
    public void яСоздаюНовыйБагСОписанием() {
        testSeleniumBug();
    }

}




