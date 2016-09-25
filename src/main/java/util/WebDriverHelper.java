package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {




   public static boolean WaitTillVisible (WebElement webElement, WebDriver driver){

        WebDriverWait wait = null;

        try {
            wait = new WebDriverWait(driver, Long.parseLong(PropertyLoader.loadProperty("timeToTimeout")), Long.parseLong(PropertyLoader.loadProperty("timeToSleep")));
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            return (false);
        }

        WebElement element = null;
        element = wait.until(ExpectedConditions.visibilityOf(webElement));
        return (element != null);
    }

    public static boolean MouseOver (WebElement webElement, WebDriver driver){

        if (WaitTillVisible(webElement, driver)) {
            Actions action = new Actions(driver);
            action.moveToElement(webElement).build().perform();
            return true;
        }
        else {
            return false;
        }
    }

    public static void AlternativeMouseOver (WebElement webElement, WebDriver driver){
            Actions action = new Actions(driver);
            action.moveToElement(webElement).build().perform();
    }

    public static void highLight(WebElement webElement, WebDriver driver) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", webElement);
            try {
                Thread.sleep(300);
            } catch (Exception ex) { }
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", webElement);
            try {
                Thread.sleep(300);
            } catch (Exception ex) { }
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", webElement);
            try {
                Thread.sleep(300);
            } catch (Exception ex) { }
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", webElement);
        }
    }

}