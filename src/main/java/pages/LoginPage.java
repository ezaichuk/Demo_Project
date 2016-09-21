package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import util.WebDriverHelper;

public class LoginPage extends Page {

    @FindBy(how = How.ID, using = "user_login")
    public WebElement username;

    @FindBy(how = How.ID, using = "user_pass")
    public WebElement password;

    @FindBy(how = How.ID, using = "wp-submit")
    public WebElement buttonLogin;

    public void LoginAs (String username, String password){
        WebDriverHelper.WaitTillVisible(this.username, driver);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        WebDriverHelper.WaitAndClick(buttonLogin, driver);
    }

    By userLogin = By.id("user_login");
    By userPass = By.id("user_pass");

//    @FindBy(xpath = "//input[@id='rememberme']")
//    public WebElement rememberme;
//
    @FindBy(xpath = "//input[@id='wp-submit']")
    public WebElement submit;





//    public WebElement user_pass = findElement(By.xpath("//input[@id='user_pass']"));


    public  void Login( String login, String password) {
        findElement(userLogin).clear();
        findElement(userLogin).sendKeys(login);
        findElement(userPass).clear();
        findElement(userPass).sendKeys(password);
        submit.click();
    }



    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
