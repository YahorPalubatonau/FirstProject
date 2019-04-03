package helpers;

import pageObjects.AbstractPage;
import pageObjects.MailBoxPage;

public class FacadeForSpamBox extends AbstractPage {
    private MailBoxPage mailBoxPage = new MailBoxPage(webDriver);

    public void facadeForSpamSection() {
        mailBoxPage.goToSpam().tipMessageinSpam().moveMessageToInput();
    }
}
