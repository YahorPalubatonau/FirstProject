package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.FacadeForSpamBox;
import org.junit.Assert;
import pageObjects.AbstractPage;
import pageObjects.MailBoxPage;

public class MailBoxPageSteps extends AbstractPage {

    public static final String WORDS_FOR_SECOND_TEST = "SELECT checkwords FROM test";
    public static final String WORDS_FOR_FIRST_TEST = "SELECT words FROM wordsfortesting";
    public static final int EXPECTED_COUNT_OF_UNMARKED_CHECKBOXES = 4;
    MailBoxPage mailBoxPage = new MailBoxPage(webDriver);
    FacadeForSpamBox facadeForSpamBox = new FacadeForSpamBox();

    @When("^user extracts mail from spam section$")
    public void extractedMessageFromSpamSection() {
        facadeForSpamBox.facadeForSpamSection();
    }


    @When("^user clicks on mail checkbox in spam section$")
    public void clickCheckboxInSpam() {
        mailBoxPage.tipMessageinSpam();
    }

    @When("^user clicks on mail checkbox$")
    public void clickCheckbox() {
        mailBoxPage.tipMessage();
    }

    @When("^user clicks on spam button$")
    public void clickSpamButton() {
        mailBoxPage.moveMessageToSpam();
    }

    @When("^user confirms add massage to spam$")
    public void confirmAddToSpam() {
        mailBoxPage.confirmMoveMessageToSpam();
    }

    @Then("^user can sees message that mail was added in spam section$")
    public void spamSection() {
        Assert.assertTrue(mailBoxPage.getTextFromSpamSection().contains(dataBase.createQuery(WORDS_FOR_FIRST_TEST, 1)));
    }


    @When("^user clicks on span section button$")
    public void clickSpanSectionButton() {
        mailBoxPage.goToSpam();
    }

    @When("^user clicks on nospam button$")
    public void clickNospamButton() {
        mailBoxPage.moveMessageToInput();
    }

    @Then("^user can sees message that mail was extracted from spam section$")
    public void spamSectionIsEmpty() {
        Assert.assertTrue(mailBoxPage.getTextFromSpamSection().contains(dataBase.createQuery(WORDS_FOR_SECOND_TEST, 1)));
    }


    @When("^user clicks on inbox mail button$")
    public void returnToInbox() {
        mailBoxPage.goToInboxDerection();
    }

    @When("^user clicks on three checkboxes$")
    public void clickOnTreeMessage() {
        mailBoxPage.tipTreeMessageinSpam();
    }

    @Then("^user can sees all three checkboxes are marked$")
    public void seeTreeCheckboxes() {
        Assert.assertEquals(EXPECTED_COUNT_OF_UNMARKED_CHECKBOXES, mailBoxPage.getCountOfSelectedChecboxes());
    }


    @When("^user clicks on unselect all button$")
    public void clickOnUnselectButton() {
        mailBoxPage.unselectAll();
    }

    @Then("^user can sees all checkboxes are unmarked$")
    public void seeEmptyAllCheckboxes() {
        Assert.assertEquals(0, mailBoxPage.getCountOfSelectedChecboxes());
    }


    @When("^user clicks on button Write mail$")
    public void clickButtonWriteMAil() {
        mailBoxPage.goToWriteSection();
    }

    @When("^user fills form To Whom:$")
    public void fillsToWhom() {
        mailBoxPage.enterToWhom();
    }

    @When("^user writes the text of mail$")
    public void writeText() {
        mailBoxPage.enterMessage();
    }

    @When("^user clicks on button Send$")
    public void sendMail() {
        mailBoxPage.clickSendButton();
    }

    @Then("^user can sees the message that mail was sended$")
    public void seeMailWasSended() {
        Assert.assertTrue(mailBoxPage.messageIsPresent());
    }
}
