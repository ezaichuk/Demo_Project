package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by rgolovatyi on 9/19/2016.
 */
public class EventListener implements WebDriverEventListener {

    WebDriverWait  wait;

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {

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
        } catch (IOException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        try {
            if (PropertyLoader.loadProperty("highlight").contains("true")) {
                WebElement element = webDriver.findElement(by);
                highLight(element, webDriver);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void onException(Throwable throwable, WebDriver webDriver) {

    }

    private void highLight(WebElement element, WebDriver driver) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
            try {
                Thread.sleep(300);
            } catch (Exception ex) { }
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
            try {
                Thread.sleep(300);
            } catch (Exception ex) { }
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
            try {
                Thread.sleep(300);
            } catch (Exception ex) { }
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
        }
    }

}
