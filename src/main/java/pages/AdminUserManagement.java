package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

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

    public void DoSearch (String search){
        userSearch.clear();
        userSearch.sendKeys(search);
        searchButton.click();
    }

    public AdminUserManagement(WebDriver driver) {
        super(driver);
    }
}
