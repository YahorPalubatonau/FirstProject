package stepDefinitions;

import api.VkAPIConnect;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import pageObjects.AbstractPage;


public class APISteps extends AbstractPage {

    private VkAPIConnect apiConnect = new VkAPIConnect();

    @When("^user enters comment$")
    public void enterCommit() {
        apiConnect.addCommitOnWall();
        logger.error("ERROR check you API");
    }

    @Then("^user can sees new comment on VK wall$")
    public void checkNewCommit() {
        Assert.assertEquals(apiConnect.getHttpResponseForAddCommit().getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        logger.trace("Assert was proceded");
    }

    @When("^user corrected comment$")
    public void correctCommit() {
        apiConnect.editCommit();
        logger.trace("Step for second test");
    }

    @Then("^user sees the corrected comment$")
    public void checkCorrectedСomment() {
        logger.info("Run second test");
        Assert.assertEquals(apiConnect.getHttpResponseForEdit().getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }
}
