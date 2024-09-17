package PageObject.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {
    public static SelenideElement loginLane = $x("//input[@id='login-form-username']");
    public static SelenideElement passwordLane = $x("//input[@id='login-form-password']");
    public static SelenideElement loginButton = $x("//input[@id='login']");
    public static SelenideElement welcome = $x("//h3[contains(text(),'Добро пожаловать в Jira')]");

}
