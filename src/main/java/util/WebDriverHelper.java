package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

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

    public static void getScreenShot() throws Exception
    {
        WebDriver driver = new FirefoxDriver();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("%USERPROFILE%" + "\\IdeaProjects\\Demo_Project\\target\\surefire-reports\\screenshot.png"));
    }

}
