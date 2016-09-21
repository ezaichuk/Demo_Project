package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }
  private void highLight(WebElement element) {
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

  public  WebElement findElement(By by) {
    WebElement element = driver.findElement(by);
    highLight(element);
    return element;
  }
}
