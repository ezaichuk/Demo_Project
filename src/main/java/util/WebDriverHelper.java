package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {

    public static boolean WaitAndClick (WebElement webElement, WebDriver driver){
        if (WaitTillClickable(webElement, driver)) {
            webElement.click();
            return true;
        }
        return false;
    }

    public static boolean WaitTillClickable(WebElement webElement, WebDriver driver) {

        WebDriverWait wait = null;

        try {
            wait = new WebDriverWait(driver, Long.parseLong(PropertyLoader.loadProperty("timeToTimeout")), Long.parseLong(PropertyLoader.loadProperty("timeToSleep")));
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            return (false);
        }

        WebElement element = null;
        element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return (element != null);
    }

}
