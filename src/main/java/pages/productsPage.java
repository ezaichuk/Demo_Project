package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class productsPage extends Page {

    @FindBy(how = How.XPATH, using = "//*[@id=\"site-navigation\"]/div[1]/ul/li[6]/a")
    public WebElement OurProductsLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/ul/li[1]/a/img")
    public WebElement GroupLink;

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

    @FindBy(how = How.LINK_TEXT, using = "Close")
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
//
//    public void Open (String URL){
//        driver.navigate().to(URL);
//    }

    public void clickProductsLink (){

        this.OurProductsLink.click();
    }

    public void clickGroupLink (){
        this.GroupLink.click();
    }

    public void ClickItemLink (){
        this.itemLink.click();
    }
//
    public void CheckItemImage (){
        itemImage.click();
        itemImageCloseButton.click();
        //itemImage.sendKeys(Keys.ESCAPE);
    }
//
//    public void ClickCheckoutLink (){ checkoutLink.click(); }
//
//    public void ClickMyAccountLink (){ myaccountLink.click(); }
//
//    public void ClickNewsLink (){ newsLink.click(); }
//
//    public void ClickOurProductsLink (){ ourProductsLink.click(); }


    public productsPage(WebDriver driver) throws IOException {
        super(driver);
    }

}
