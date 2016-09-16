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

    public void Open (String URL){
        driver.navigate().to(URL);
    }

    public void ClickLoginLink (){
        WebDriverHelper.WaitAndClick(loginLink, driver);
    }

    public MainPage(WebDriver driver) throws IOException {
        super(driver);
    }

}
