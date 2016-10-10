package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminUserDeletion extends Page {

    @FindBy(how = How.ID, using = "submit")
    public WebElement submitButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='updateusers']/div/ul/li")
    public WebElement usersToDelete;

    public void submitDeletion(){
        submitButton.click();
    }

    public AdminUserDeletion(WebDriver driver) {
        super(driver);
    }
}
