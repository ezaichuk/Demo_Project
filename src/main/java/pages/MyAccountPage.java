package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import util.WebDriverHelper;

public class MyAccountPage extends Page {

    @FindBy(how = How.LINK_TEXT, using = "Addresses")
    public WebElement linkAddresses;

    @FindBy(how = How.CLASS_NAME, using = "entry-title")
    public WebElement entryTitle;

    @FindBy(how = How.ID, using = "user_login")
    public WebElement inputUsernameEmail;

    @FindBy(how = How.XPATH, using = "//input[@value = 'Reset Password']")
    public WebElement buttonResetPassword;

    @FindBy(how = How.CLASS_NAME, using = "woocommerce-message")
    public WebElement validMessage;

    @FindBy(how = How.ID, using = "username")
    public WebElement username;

    @FindBy(how = How.ID, using = "password")
    public WebElement password;

    @FindBy(how = How.NAME, using = "login")
    public WebElement buttonLogin;

    @FindBy(how = How.LINK_TEXT, using = "Sign out")
    public WebElement linkSignOut;

    @FindBy(how = How.LINK_TEXT, using = "Account Details")
    public WebElement linkAccountDetails;

    @FindBy(how = How.CLASS_NAME, using = "woocommerce-MyAccount-content")
    public WebElement loginMessage;

    @FindBy(how = How.XPATH, using = ".//ul[@class='woocommerce-error']")
    public WebElement loginErrorMessage;

    @FindBy(how = How.LINK_TEXT, using = "Dashboard")
    public WebElement dashboardLink;

    @FindBy(how = How.LINK_TEXT, using = "Orders")
    public WebElement ordersLink;

    @FindBy(how = How.LINK_TEXT, using = "Downloads")
    public WebElement downloadsLink;

    @FindBy(how = How.LINK_TEXT, using = "Addresses")
    public WebElement addressesLink;

    @FindBy(how = How.LINK_TEXT, using = "Logout")
    public WebElement logoutLink;


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void Open (String URL){
        driver.navigate().to(URL + "/my-account");
    }

    public void OpenAccountDetails ()
    {
        linkAccountDetails.click();
    }

    public void OpenAddressesLink()
    {
        linkAddresses.click();
    }

    public void LoginAs (String username, String password){
        this.username.clear();
        this.password.clear();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.buttonLogin.click();
    }

    public void SignOut()
    {
        linkSignOut.click();
    }
}
