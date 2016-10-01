package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 */
public class AdminPageInnerTab extends Page {

    @FindBy(xpath = ".//div[contains(@class,'wrap')]/h1")
    public WebElement headerofTab;

    @FindBy(xpath = ".//a[@class='page-title-action']")
    public WebElement addNewElement;

    @FindBy(xpath = ".//div[@id='titlewrap']/input")
    public WebElement addNewItemName;

    @FindBy(xpath = ".//label[@id='title-prompt-text']")
    public WebElement titlePromptText;

    @FindBy(xpath = ".//button[@id='insert-media-button']")
    public WebElement insertMediaButton;

    @FindBy(xpath = ".//*[@id='wp-word-count']")
    public WebElement wordCountLabel;

    @FindBy(xpath = ".//*[@class='word-count']")
    public WebElement wordCountNumber;

    @FindBy(xpath = ".//label[@for='post_status']")
    public WebElement postStatusLabel;

    @FindBy(xpath = ".//*[@id='timestamp']/b")
    public WebElement postTimestamp;

    @FindBy(xpath = ".//*[@id='last-edit']")
    public WebElement lastEdit;

    @FindBy(xpath = ".//input[@id='publish']")
    public WebElement publishOrUpdateButton;

    @FindBy(xpath = ".//div[@id='message']/p")
    public WebElement publishOrUpdateMessageBox;

    @FindBy(xpath = ".//span[@id='post-status-display']")
    public WebElement statusField;

    @FindBy(xpath = ".//iframe[@id='content_ifr']")
    public WebElement innerFrame;

    @FindBy(xpath = ".//body[@id='tinymce']/p") // inside iframe#content_fr
    public WebElement addNewItemBodyText;

    public void AddNewPost(String titleToAddNewPost, String bodyToAddNewPost, String nameOfTest) {
        addNewItemName.sendKeys(titleToAddNewPost + nameOfTest);
        driver.switchTo().frame(innerFrame);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].innerHTML = '" + bodyToAddNewPost + nameOfTest + "'", addNewItemBodyText);
        driver.switchTo().defaultContent();
        publishOrUpdateButton.click();
    }

    public AdminPageInnerTab(WebDriver webDriver) {
        super(webDriver);
    }
}
