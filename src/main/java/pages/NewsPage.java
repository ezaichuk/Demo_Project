package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewsPage extends Page {

    @FindBy(how = How.LINK_TEXT, using = "News")
    public WebElement newsLink;

    @FindBy(how = How.ID, using = "pwbox-2")
    public WebElement password;

    @FindBy(how = How.XPATH, using = "//form[@class='post-password-form']/p[2]/input")
    public WebElement buttonLogin;

    @FindBy(how = How.XPATH, using = "//form[@class='post-password-form']/p[1]")
    public WebElement newsTitle;

    @FindBy(how = How.XPATH, using = "//div[@class='entry-content']/p[1]")
    public WebElement newsTitleProtected;

    public void Open (String URL){
        driver.navigate().to(URL);
    }

    public void AdminNews (String password){
        this.password.sendKeys(password);
        this.buttonLogin.click();
    }

    public void ClickNewsLink (){ newsLink.click(); }

    public NewsPage(WebDriver driver) {
        super(driver);
    }
}
