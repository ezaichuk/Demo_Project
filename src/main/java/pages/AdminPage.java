package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import util.WebDriverHelper;

import java.util.List;

public class AdminPage extends Page {

    @FindBy(xpath=".//*[@id='wp-admin-bar-logout']/a")
    public WebElement logoutLink;

    @FindBy(xpath=".//*[@id='wp-admin-bar-new-content']")
    public WebElement plusMenu;

    @FindBy(how = How.ID, using= "wp-admin-bar-my-account")
    public WebElement myAccountMenu;

    @FindBy(xpath=".//a[@href='post-new.php']")
    public WebElement addNewPostViaPostsMenu;

    @FindBy(xpath=".//*[@id='wp-admin-bar-new-post']/a")
    public WebElement addNewPostViaPlusMenu;

    @FindBy(how = How.ID, using = "wp-admin-bar-new-user")
    public WebElement addUserTopMenu;

    @FindBy(how = How.XPATH, using = "//div[@class = 'wp-menu-name'][text() = 'Users']")
    public WebElement leftPanelUsersMenu;

    @FindBy(how = How.XPATH, using = ".//*[@id='menu-users']/ul/li[3]/a")
    public WebElement leftPanelAddUser;

    @FindBy(how = How.ID, using = "menu-posts") //BG
    public WebElement postsMenu;

    @FindBy(how = How.ID, using = "menu-dashboard") //BG
    public WebElement dashboardMenu;

    @FindBys({@FindBy(xpath = ".//div[@class='wp-menu-name']")})
    public  List<WebElement> namesOfTab;

    public void ClickLogoutLink(){
        WebDriverHelper.MouseOver(myAccountMenu,driver);
        logoutLink.click();
    }
    public void clickOnNeededTab (String nameOfTab)  {
        for(WebElement webElement: namesOfTab){
            if (webElement.getText().trim().contains(nameOfTab)) {
                webElement.click();
                break;
            }
        }
    }

    public void actionOnMenu (String nameOfMenu, Boolean clickOrMouseOver) {
        for (WebElement webElement : namesOfTab) {
            if (webElement.getText().trim().contains(nameOfMenu)) {
                if (clickOrMouseOver) webElement.click();
                else {
                    WebDriverHelper.MouseOver(webElement, driver);
                }
                break;
            }
        }
    }

    public void SubMenuItem(WebElement webElement, String searchedSubMenuItem){
        List<WebElement> listOfItemInSubMenu = webElement.findElements(By.xpath(".//ul/.//a"));
        for(WebElement item : listOfItemInSubMenu){
            if (item.getText().equals(searchedSubMenuItem)){
                item.click();
                break;
            }
        }
    }

    public void AddUserTopMenu (){
        WebDriverHelper.MouseOver(plusMenu, driver);
        addUserTopMenu.click();
    }

    public void AddUserLeftPanel (){
        actionOnMenu("Users", true);
        leftPanelAddUser.click();
    }

    public AdminPage(WebDriver driver) {
        super(driver);
    }
}
