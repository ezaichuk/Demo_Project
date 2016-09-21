package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 */
public class AdminConsole extends Page {

    By loggedUserBoxBy = By.xpath(".//*[@id='wp-admin-bar-my-account']/a");
//    public WebElement loggedUserBox = findElement(loggedUserBoxBy);

    public WebElement loggedUserBox() {
       return  findElement(loggedUserBoxBy);

    }

    public AdminConsole(WebDriver webDriver) {
        super(webDriver);
    }
}
