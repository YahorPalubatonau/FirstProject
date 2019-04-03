package pageObjects;


import dataBase.DataBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.Singleton;

import java.util.concurrent.TimeUnit;


public class AbstractPage {

    private static final int LINK_PRESENSE_TIMEOUT = 11000;
    private static final String SELECT_URL_FROM_WEBPAGES = "SELECT URL FROM webpages";
    protected static WebDriver webDriver;
    protected static DataBase dataBase = new DataBase();
    public final static Logger logger = Logger.getLogger(AbstractPage.class);

    public void getWebDriver() {
        webDriver = Singleton.getSingletoneWebDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(dataBase.createQuery(SELECT_URL_FROM_WEBPAGES, 1));
    }

    public boolean waitForWebElementPresent(WebElement element) {
        try {
            return new WebDriverWait(webDriver, LINK_PRESENSE_TIMEOUT)
                    .until(ExpectedConditions.visibilityOf(element))
                    .isDisplayed();
        } catch (StaleElementReferenceException ex) {
            return new WebDriverWait(webDriver, LINK_PRESENSE_TIMEOUT)
                    .until(ExpectedConditions.visibilityOf(element))
                    .isDisplayed();
        }
    }

    public void waitForWebElementClickable(WebElement element) {
        new WebDriverWait(webDriver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));

    }


}


