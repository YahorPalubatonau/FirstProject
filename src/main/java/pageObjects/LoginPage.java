package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends AbstractPage {

    private static final String LOGIN = "SELECT name FROM User";
    private static final String PASSWORD = "SELECT password FROM User";
    private String searchWords = "ter";

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(xpath = ".//a[@class ='logo__img']")
    private WebElement logoField;

    @FindBy(xpath = ".//input[@name='q']")
    private WebElement searchFileldOnMailRu;

    @FindBy(xpath = ".//div[@id='suggests-list']//div")
    private List<WebElement> listItemsOfSuggests;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "//*[@id='PH_logoutLink']")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id='mailbox:error']")
    public WebElement logoutLinkError;


    public LoginPage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        this.webDriver = webdriver;
    }


    public void enterLoginAndPass() {
        loginField.clear();
        loginField.sendKeys(dataBase.createQuery(LOGIN, 1));
        passwordField.clear();
        passwordField.sendKeys(dataBase.createQuery(PASSWORD, 1));
    }

    public void clickEnterButton() {
        buttonEnter.click();
    }

    public boolean logoutLinkPresents() {
        return waitForWebElementPresent(logoutLink);

    }

    public boolean logoMailRuPresents() {
        return waitForWebElementPresent(loginField);
    }

    public void enterTreeSymbols() {
        searchFileldOnMailRu.clear();
        searchFileldOnMailRu.sendKeys(searchWords);
    }

    public int countsOfSuggests() {
        return listItemsOfSuggests.size();
    }
}