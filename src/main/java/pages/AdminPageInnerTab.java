package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 */
public class AdminPageInnerTab extends Page {

    @FindBy(xpath = ".//div[@class='wrap']/h1")
    public WebElement headerofTab;

    @FindBy(xpath = ".//a[@class='page-title-action']")
    public WebElement addNewElement;

    @FindBy(xpath = ".//div[@id='titlewrap']/input")
    public WebElement addNewItemName;

    @FindBy(xpath = ".//input[@id='publish']")
    public WebElement publishOrUpdateButton;

    @FindBy(xpath = ".//span[@id='post-status-display']")
    public WebElement statusField;


    @FindBy(xpath = ".//iframe[@id='content_ifr']")
    public WebElement innerFrame;

    @FindBy(xpath = ".//body[@id='tinymce']/p") // inside iframe#content_fr
    public WebElement addNewItemBodyText;





    public AdminPageInnerTab(WebDriver webDriver) {
        super(webDriver);
    }
}
