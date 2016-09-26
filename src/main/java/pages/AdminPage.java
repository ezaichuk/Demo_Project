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

    @FindBy(xpath=".//*[@id='wp-admin-bar-logout']/a")
    public WebElement alternativeLogoutLink;

    @FindBy(xpath=".//*[@id='wp-admin-bar-new-content']")
    public WebElement plusMenu;


    @FindBy(how = How.ID, using= "wp-admin-bar-my-account")
    public WebElement myAccountMenu;

    @FindBy(xpath=".//a[@href='post-new.php']")
    public WebElement addNewPostViaPostsMenu;

    @FindBy(xpath=".//*[@id='wp-admin-bar-new-post']/a")
    public WebElement addNewPostViaPlusMenu;



    public void ClickLogoutLink (){
        WebDriverHelper.MouseOver(myAccountMenu, driver);
        logoutLink.click();
    }

    public void ClickAlternativeLogoutLink (){
        WebDriverHelper.AlternativeMouseOver(myAccountMenu,driver);
        alternativeLogoutLink.click();
    }


    @FindBys({@FindBy(xpath = ".//div[@class='wp-menu-name']")})
//    @CacheLookup
    public  List<WebElement> namesOfTab;



    public void clickOnNeededTab (String nameOfTab)  {
        for(WebElement webElement: namesOfTab){
            if (webElement.getText().trim().contains(nameOfTab)) {
                webElement.click();
                break;
            }
        }
    }

    public void actionOnMenu (String nameOfMenu, Boolean clickOrMouseOver)  {
        for(WebElement webElement: namesOfTab){
            if (webElement.getText().trim().contains(nameOfMenu)) {
                if (clickOrMouseOver) webElement.click();
                else {
                    WebDriverHelper.AlternativeMouseOver(webElement,driver);
                }
                break;
            }
        }
    }

    public AdminPage(WebDriver driver) {
        super(driver);
    }
}
