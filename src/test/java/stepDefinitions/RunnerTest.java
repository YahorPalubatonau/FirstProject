package stepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.AbstractPage;
import pageObjects.MailBoxPage;
import webDriver.Singleton;


@CucumberOptions(features = {"src/test/resources/features/"},
        tags = {})
public class RunnerTest extends AbstractTestNGCucumberTests {

    @BeforeClass(dependsOnGroups = "~@API", alwaysRun = true)
    public void getWebDriver() {
        AbstractPage abstractPage = new AbstractPage();
        abstractPage.getWebDriver();
    }

    @Before(value = "~@API")
    public void getWebDriver1() {
        AbstractPage abstractPage = new AbstractPage();
        abstractPage.getWebDriver();
    }

    @After(value = "@MailRu")
    public void afterScenario() {
        MailBoxPage mailBoxPage = new MailBoxPage(Singleton.getSingletoneWebDriver());
        mailBoxPage.quitFromMail();
    }

    @AfterClass(dependsOnGroups = "~@API", alwaysRun = true)
    public static void closeResources() {
        Singleton.getSingletoneWebDriver().quit();
    }

}