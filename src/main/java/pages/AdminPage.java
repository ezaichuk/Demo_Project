package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import util.WebDriverHelper;

public class AdminPage extends Page {

    @FindBy(how = How.LINK_TEXT, using = "Log Out")
    public WebElement logoutLink;

    @FindBy(how = How.ID, using= "wp-admin-bar-my-account")
    public WebElement myAccountMenu;

    public void ClickLogoutLink (){
        WebDriverHelper.MouseOver(myAccountMenu, driver);
        logoutLink.click();
    }

    public AdminPage(WebDriver driver) {
        super(driver);
    }
}
