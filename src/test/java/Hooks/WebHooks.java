package Hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import static com.sun.activation.registries.LogSupport.log;

/**
 * Класс с настройками драйвера.
 * */
public class WebHooks {

    @BeforeEach()
    public void setDriverFromProps() {
        WebDriver driver;
        driver = new ChromeDriver();
        Configuration.pageLoadTimeout = 200000;
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);

    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }

    @Attachment(type = "application/pdf")
    public byte[] attachPdfFile(String pdfLocation) throws IOException {
        File pdf = new File(pdfLocation);
        try {
            return Files.toByteArray(pdf);
        } catch (IOException e) {
            log("attachPdfFile() : не выполнено " + e.getMessage());
            return new byte[0];
        }
    }

    /**
     * Метод аллюр менеджер: для отображения в аллюре селенидовских шагов при наличии в проекте параллелизации
     */
    @BeforeEach
    public void allureSubThreadParallel(){
//        String listenerName = "AllureSelenide";
        String listenerName = "CustomAllureSelenide";

//        if(!(SelenideLogger.hasListener(listenerName)))
//            SelenideLogger.addListener(listenerName,
//                    new CustomAllureSelenide(Allure.getLifecycle())
//            );
        /**
         * Ниже стандартное скриншотирование только на упавших тестах
         * */
                    new AllureSelenide().
                            screenshots(true).
                            savePageSource(false);
    }

    @AfterEach()
    public void driverClose() {
        /**
         * Строка с AllureHelper нужна для прикрепления скриншота перед закрытием драйвера
         * */
        new AllureHelper().afterTestExecution();
        WebDriverRunner.closeWebDriver();
    }
}
