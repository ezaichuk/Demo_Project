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

    @FindBy(how = How.LINK_TEXT, using = "Home")
    public WebElement homeLink;

    @FindBy(how = How.LINK_TEXT, using = "Cart")
    public WebElement cartLink;

    @FindBy(how = How.LINK_TEXT, using = "Checkout")
    public WebElement checkoutLink;

    @FindBy(how = How.LINK_TEXT, using = "My account")
    public WebElement myaccountLink;

    @FindBy(how = How.LINK_TEXT, using = "News")
    public WebElement newsLink;

    @FindBy(how = How.LINK_TEXT, using = "Our products")
    public WebElement ourProductsLink;

    public void Open (String URL){
        driver.navigate().to(URL);
    }

    public void ClickLoginLink (){

        this.loginLink.click();
    }

    public void ClickLogoutLink (){
        this.logoutLink.click();
    }

    public void ClickHomeLink (){ WebDriverHelper.WaitAndClick(homeLink, driver); }

    public void ClickCartLink (){ WebDriverHelper.WaitAndClick(cartLink, driver); }

    public void ClickCheckoutLink (){ WebDriverHelper.WaitAndClick(checkoutLink, driver); }

    public void ClickMyAccountLink (){ WebDriverHelper.WaitAndClick(myaccountLink, driver); }

    public void ClickNewsLink (){ WebDriverHelper.WaitAndClick(newsLink, driver); }

    public void ClickOurProductsLink (){ WebDriverHelper.WaitAndClick(ourProductsLink, driver); }


    public MainPage(WebDriver driver) throws IOException {
        super(driver);
    }

}
