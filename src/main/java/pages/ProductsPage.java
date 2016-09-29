package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class ProductsPage extends Page {

    @FindBy(how = How.XPATH, using = "//*[@id=\"site-navigation\"]/div[1]/ul/li[6]/a")
    public WebElement ourProductsLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/ul/li[1]/a/img")
    public WebElement groupLink;

    @FindBy(how = How.CSS, using = "span.onsale")
    public WebElement specialLabel;
//
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/ul/li[1]/a[1]/img")
    public WebElement itemLink;
//
    @FindBy(how = How.CSS, using = "p.stock.in-stock")
    public WebElement stockCount;

    @FindBy(how = How.XPATH, using = "//img[@alt='funnygifts-2']")
    public WebElement itemImage;

    @FindBy(how = How.CLASS_NAME, using = "pp_close")
    public WebElement itemImageCloseButton;

    @FindBy(how = How.NAME, using = "quantity")
    public WebElement itemQuantity;

    @FindBy(how = How.XPATH, using = "//*[@id=\"tab-description\"]/p/img")
    public WebElement itemDescription;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement addToCartButton;
//
    @FindBy(how = How.LINK_TEXT, using = "5")
    public WebElement itemRating;
//
    @FindBy(how = How.ID, using = "comment")
    public WebElement itemComment;

    @FindBy(how = How.ID, using = "author")
    public WebElement reviewAuthor;

    @FindBy(how = How.ID, using = "email")
    public WebElement authorEmail;
//
    @FindBy(how = How.ID, using = "submit")
    public WebElement addReview;

//    public void Open (String URL){
//        driver.navigate().to(URL);
//    }

    public void ClickProductsLink(){

        ourProductsLink.click();
    }

    public void ClickGroupLink(){
        groupLink.click();
    }

    public void ClickItemLink (){
        itemLink.click();
    }
//
    public void CheckItemImage (){
        itemImage.click();
        itemImageCloseButton.click();
        //itemImage.sendKeys(Keys.ESCAPE);
    }


    public ProductsPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public void AddReviewPost(String reviewText, String reviewerName, String reviewerEmail) {
        itemRating.click();
        itemComment.clear();
        itemComment.sendKeys(reviewText);
        reviewAuthor.clear();
        reviewAuthor.sendKeys(reviewerName);
        authorEmail.clear();
        authorEmail.sendKeys(reviewerEmail);
        addReview.click();
    }
}
