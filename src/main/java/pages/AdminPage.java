package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import util.WebDriverHelper;

import java.util.List;

public class AdminPage extends Page {

    @FindBy(how = How.LINK_TEXT, using = "Log Out")
    public WebElement logoutLink;

    @FindBy(how = How.ID, using= "wp-admin-bar-my-account")
    public WebElement myAccountMenu;


    public void ClickLogoutLink (){
        WebDriverHelper.MouseOver(myAccountMenu, driver);
        logoutLink.click();
    }


    @FindBys({@FindBy(xpath = ".//div[@class='wp-menu-name']")})
//    @CacheLookup
    public  List<WebElement> namesOfTab;

    public void clickOnNeededTab (String nameOfTab)  {
        for(WebElement webElement: namesOfTab){
//            System.out.println(webElement);
            if (webElement.getText().trim().contains(nameOfTab)) {
                webElement.click();
                break;
//                return true;
            }
        }
//        return false;
    }


    public AdminPage(WebDriver driver) {
        super(driver);
    }
}
