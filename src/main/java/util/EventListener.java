package util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by rgolovatyi on 9/19/2016.
 */
public class EventListener implements WebDriverEventListener {
    private WebDriverHelper webDriverHelper;
    WebDriverWait  wait;
    private Log log = LogFactory.getLog(this.getClass());
    private By lastFindBy;

    @Override
    public void beforeNavigateTo(String url, WebDriver webDriver) {
        log.info("WebDriver navigating to:'"+url+"'");
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        try {
            wait = new WebDriverWait(webDriver,Long.parseLong(PropertyLoader.loadProperty("timeToTimeout")));
            lastFindBy = by;
            webDriverHelper.highLight(webDriver.findElement(by),webDriver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        try {
            wait = new WebDriverWait(webDriver,Long.parseLong(PropertyLoader.loadProperty("timeToTimeout")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable error, WebDriver webDriver) {
        if (error.getClass().equals(NoSuchElementException.class)){
            log.error("WebDriver error: Element not found "+lastFindBy);
        } else {
            log.error("WebDriver error:", error);
        }
    }


}
