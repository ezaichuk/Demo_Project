package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminUserManagement extends Page {

    @FindBy(xpath = ".//a[@class='page-title-action']")
    public WebElement addNewElement;

    public AdminUserManagement(WebDriver driver) {
        super(driver);
    }
}
