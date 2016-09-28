package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import util.WebDriverHelper;
import java.util.List;

public class AdminUserManagement extends Page {

    @FindBy(xpath = ".//a[@class='page-title-action']")
    public WebElement addNewElement;

    @FindBy(how = How.ID, using = "user-search-input" )
    public WebElement userSearch;

    @FindBy(how = How.ID, using = "search-submit")
    public WebElement searchButton;

    @FindBys({@FindBy (xpath = ".//tbody[@id='the-list']/tr")})
    public List<WebElement> userList;

    @FindBy(how = How.ID, using = "cd-select-all-1")
    public WebElement selectAllCheckbox;

    @FindBy(how = How.XPATH, using = ".//*[@id='message']/p")
    public WebElement message;

    @FindBy(how = How.XPATH, using = ".//*[@id='the-list']/tr/td")
    public WebElement searchMessage;

    public void DoSearch (String search){
        userSearch.clear();
        userSearch.sendKeys(search);
        searchButton.click();
    }

    public AdminUserManagement(WebDriver driver) {
        super(driver);
    }

    public boolean DeleteUser(String username) {
        WebElement userlink;
        WebElement delete;
        DoSearch(username);
        if (userList.size() != 1) {
            return false;
        }else{
            userlink = userList.get(0).findElement(By.xpath(".//td[@data-colname='Username']"));
            WebDriverHelper.MouseOver(userlink, driver);
            delete = userList.get(0).findElement(By.xpath(".//td[@data-colname='Username']/div/span[2]/a"));
            delete.click();
            return true;
        }
    }
}
