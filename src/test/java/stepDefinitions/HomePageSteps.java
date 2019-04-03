package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import pageObjects.AbstractPage;


public class HomePageSteps extends AbstractPage {

    private LoginPage loginPage = new LoginPage(webDriver);

    @When("^user login in mailBox$")
    public void loginToMailBox() {
        loginPage.enterLoginAndPass();
        loginPage.clickEnterButton();
        loginPage.logoutLinkPresents();
    }

    @Then("^user can sees Mailbox page$")
    public void checkLoginInMail() {
        Assert.assertTrue(loginPage.logoutLinkPresents());
    }

    @Then("^user can sees logo MailRu$")
    public void userOnMailRu() {
        Assert.assertTrue(loginPage.logoMailRuPresents());
    }

    @When("^user enters tree symbols$")
    public void enterSymbols() {
        loginPage.enterTreeSymbols();
    }

    @Then("^user sees list of suggests$")
    public void checkSuggests() {
        Assert.assertEquals(10,loginPage.countsOfSuggests());
    }
}

