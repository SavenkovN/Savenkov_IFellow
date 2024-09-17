package PageObject.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage {

    //public static SelenideElement pageTasks = $x("//a[@title='Поиск и просмотр недавних задач']");
    //public static SelenideElement pageFindTasks = $x("//a[@id='issues_new_search_link_lnk']");
    public static SelenideElement pagesCountElem = $x("//div[@class='showing']//span");
    public static SelenideElement allTasksAndFilters = $x("//a[contains(text(),'Посмотреть все задачи и фильтры')]");
    public static SelenideElement inputNameTask = $x("//input[@class='search-entry text medium-field ajs-dirty-warning-exempt']");
    public static SelenideElement searchButton = $x("//button[@class='aui-button aui-button-primary search-button']");
    public static SelenideElement selectNeedTask = $x("//span[contains(text(),'TestSeleniumAT')]");
    public static SelenideElement assertStatus = $x("//span[contains(text(),'Сделать')]");
    public static SelenideElement assertVersion = $x("//a[contains(text(),'Version 2.0')]");
    public static SelenideElement createLink = $x("//a[@id='create_link']");
    public static SelenideElement typeTask = $x("//input[@id='issuetype-field']");
    public static SelenideElement themeTask = $x("//input[@id='summary']");
    public static SelenideElement descriptionTextButton = $x("//div[@class='aui-dialog2-content jira-dialog-core-content']//descendant::li[@class='aui-nav-selected']//child::button[@class='aui-button' and contains(text(),'Текст')]");
    public static SelenideElement textAreaDescription = $x("//textarea[@id='description']");
    public static SelenideElement versionAreaDescription = $x("//label[contains(text(),'Исправить в версиях')]//parent::div[@class='field-group aui-field-versionspicker select-list-renderer']//descendant::option[@value='10001']");
    public static SelenideElement propertyTask = $x("//input[@id='priority-field']");
    public static SelenideElement labelTask = $x("//textarea[@id='labels-textarea']");
    public static SelenideElement textEnvironment = $x("//textarea[@id='environment']");
    public static SelenideElement sunkVersion = $x("//label[contains(text(),'Затронуты')]//parent::div[@class='field-group aui-field-versionspicker select-list-renderer']//descendant::option[@value='10001']");
    public static SelenideElement task = $x("//textarea[@id='issuelinks-issues-textarea']");
    public static SelenideElement sprint = $x("//input[@id='customfield_10104-field']");
    public static SelenideElement create = $x("//input[@id='create-issue-submit']");
    public static SelenideElement myTask = $x("//a[@class='issue-created-key issue-link']");
    public static SelenideElement statusInWork = $x("//span[@class='trigger-label' and contains(text(),'В работе')]");
    public static SelenideElement businessProcess = $x("//span[@class='dropdown-text' and contains(text(),'Бизнес-процесс')]");
    public static SelenideElement statusWin = $x("//span[@class='trigger-label' and contains(text(),'Выполнено')]");
    public static SelenideElement getAssertStatusMyTask = $x("//span[@class=' jira-issue-status-lozenge aui-lozenge jira-issue-status-lozenge-green jira-issue-status-lozenge-done jira-issue-status-lozenge-max-width-medium']");

}
