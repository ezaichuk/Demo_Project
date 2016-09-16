package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import util.WebDriverHelper;

import java.io.IOException;

public class MainPage extends Page {

    @FindBy(how = How.LINK_TEXT, using = "Log in")
    public WebElement loginLink;

    @FindBy(how = How.LINK_TEXT, using = "Log out")
    public WebElement logoutLink;

    @FindBy(how = How.XPATH, using = "//div[@class='woocommerce-MyAccount-content']/p[1]")
    public WebElement myAccountContent;

    public void Open (String URL){
        driver.navigate().to(URL);
    }

    public void ClickLoginLink (){
        WebDriverHelper.WaitAndClick(loginLink, driver);
    }

    public void ClickLogoutLink (){
        WebDriverHelper.WaitAndClick(logoutLink, driver);
    }

    public MainPage(WebDriver driver) throws IOException {
        super(driver);
    }

}
