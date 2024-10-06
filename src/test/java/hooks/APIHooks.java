package hooks;

import io.qameta.allure.Attachment;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.engine.Filter;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class APIHooks implements BeforeAllCallback {

    private static boolean started = false;
    private LauncherDiscoveryRequestBuilder RestAssured;

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        if(!started) {
            started = true;
            RestAssured.filters((Filter<?>) new AllureRestAssured());
        }
    }

    @Attachment(value = "Читаемый Json файл", type = "application/json", fileExtension = ".txt")
    public static byte[] getJson(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/test/resources", resourceName));
    }
}