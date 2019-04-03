package pageObjects;

import org.apache.log4j.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MailBoxPage extends AbstractPage {

    public static final String SELECT_TEXT = "SELECT text FROM message";
    public static final String SELECT_EMAIL = "SELECT email FROM Emails";

    @FindBy(xpath = ".//div[@class='js-checkbox b-checkbox']//div[@class='b-checkbox__box']")
    List<WebElement> checkBoxOfMessage;

    @FindBy(xpath = ".//div[@class='js-checkbox b-checkbox b-checkbox_checked']")
    List<WebElement> checkBoxOfMessageAfterSelected;

    @FindBy(xpath = ".//div[@title='Спам (J)']")
    WebElement spamButton;

    @FindBy(xpath = ".//a[@href='/messages/spam/']")
    WebElement spamSection;

    @FindBy(className = "b-nav__link")
    WebElement spamSectionIsDisplayed;

    @FindBy(xpath = ".//div[@title='Не спам (J)']")
    WebElement nospamButton;

    @FindBy(xpath = ".//span[contains(text(),'Входящие')]")
    WebElement inboxButton;

    @FindBy(xpath = ".//div[@id='b-toolbar__right']//div[@data-cache-key='0_undefined_false']//div[@class='b-checkbox__box']")
    WebElement unselectAllButton;

    @FindBy(xpath = ".//div[@id='b-toolbar__left']//div//a[contains(@class,'b-toolbar__btn b-toolbar__btn_with-foldings js-shortcut')]")
    WebElement writeMailButton;
    @FindBy(xpath = ".//textarea[@data-original-name='To']")
    WebElement fieldOfToWhom;

    @FindBy(xpath = ".//iframe[@allowtransparency=\"true\"]")
    WebElement changeFrame;

    @FindBy(xpath = ".//body[@id='tinymce']")
    WebElement fieldOfMessage;

    @FindBy(xpath = ".//div[@id='b-toolbar__right']//div//div[@class='b-toolbar__btn b-toolbar__btn_ b-toolbar__btn_false js-shortcut']")
    WebElement sendButton;

    @FindBy(xpath = ".//div[@class='message-sent__title']")
    WebElement textInWindow;

    @FindBy(xpath = ".//*[@id='PH_logoutLink']")
    private WebElement logoutLink;

    @FindBy(xpath = ".//span[contains(text(),'Да, перемещать')]")
    private WebElement buttonAddToSpam;

    public MailBoxPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public MailBoxPage tipMessage() {
        waitForWebElementClickable(checkBoxOfMessage.get(0));
        checkBoxOfMessage.get(0).click();
        return new MailBoxPage(webDriver);
    }

    public MailBoxPage tipMessageinSpam() {
        waitForWebElementClickable(checkBoxOfMessage.get(2));
        checkBoxOfMessage.get(2).click();
        return new MailBoxPage(webDriver);
    }

    public void tipTreeMessageinSpam() {
        checkBoxOfMessage.get(2).click();
        checkBoxOfMessage.get(1).click();
        checkBoxOfMessage.get(0).click();
    }

    public int getCountOfSelectedChecboxes() {
        return checkBoxOfMessageAfterSelected.size();
    }

    public void unselectAll() {
        unselectAllButton.click();
        unselectAllButton.click();
    }

    public void moveMessageToSpam() {
        spamButton.click();
    }

    public void confirmMoveMessageToSpam() {
        waitForWebElementClickable(buttonAddToSpam);
        buttonAddToSpam.click();
    }

    public String getTextFromSpamSection() {
        waitForWebElementPresent(spamSection);
        System.out.println(spamSection.getAttribute("title"));
        logger.log(Level.INFO, "Text" + spamSection.getAttribute("title") + "was get");
        return spamSection.getAttribute("title");
    }

    public MailBoxPage goToSpam() {
        try {
            spamSection.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            spamSection.click();
        }
        return new MailBoxPage(webDriver);
    }

    public MailBoxPage moveMessageToInput() {
        nospamButton.click();
        return new MailBoxPage(webDriver);
    }

    public void goToInboxDerection() {
        inboxButton.click();
    }

    public void goToWriteSection() {

        writeMailButton.click();
    }

    public void enterToWhom() {
        fieldOfToWhom.clear();
        fieldOfToWhom.sendKeys(dataBase.createQuery(SELECT_EMAIL, 1));
    }

    public void enterMessage() {
        webDriver.switchTo().frame(changeFrame);
        fieldOfMessage.click();
        fieldOfMessage.clear();
        fieldOfMessage.sendKeys(dataBase.createQuery(SELECT_TEXT, 1));
        webDriver.switchTo().defaultContent();
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public void quitFromMail() {
        logoutLink.click();
    }

    public boolean messageIsPresent() {
        logger.log(Level.INFO, "Message is disolayed");
        return (new WebDriverWait(webDriver, 3000)).until(ExpectedConditions.visibilityOf(textInWindow))
                .isDisplayed();
    }

}
