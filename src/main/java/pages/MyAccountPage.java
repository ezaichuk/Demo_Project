package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountPage extends Page {

    @FindBy(how = How.CLASS_NAME, using = "entry-title")
    public WebElement entryTitle;

    @FindBy(how = How.ID, using = "user_login")
    public WebElement inputUsernameEmail;

    @FindBy(how = How.XPATH, using = "//input[@value = 'Reset Password']")
    public WebElement buttonResetPassword;

    @FindBy(how = How.XPATH, using = "//ul[@class = 'woocommerce-error']/li")
    public WebElement errorMessage;

    @FindBy(how = How.CLASS_NAME, using = "woocommerce-message")
    public WebElement validMessage;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
}
