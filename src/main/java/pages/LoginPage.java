package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Page {

    @FindBy(how = How.ID, using = "user_login")
    public WebElement username;

    @FindBy(how = How.ID, using = "user_pass")
    public WebElement password;

    @FindBy(how = How.ID, using = "wp-submit")
    public WebElement buttonLogin;

    @FindBy(how = How.CLASS_NAME, using = "message")
    public WebElement loginMessage;

    @FindBy(how = How.ID, using = "login_error")
    public WebElement loginErrorMessage;

    @FindBy(how = How.LINK_TEXT, using = "Lost your password?")
    public WebElement lostPasswordLink;

    public void Open (String URL){
        driver.navigate().to(URL + "/wp-login.php");
    }

    public void LoginAs (String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.buttonLogin.click();
    }

    public void LostPasswordClick (){
        lostPasswordLink.click();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
