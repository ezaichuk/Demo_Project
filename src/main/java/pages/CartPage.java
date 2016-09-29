package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by rgolovatyi on 9/29/2016.
 */
public class CartPage extends Page {

    @FindBy(how = How.CSS, using = ".remove" )
    public WebElement removeButton;

    @FindBys({@FindBy(how = How.CSS, using = ".product-name>a")})
    public List<WebElement> listOfProductsInCart;

    @FindBys({@FindBy(how = How.XPATH, using = "//td[contains(@class, 'product-price')]/span")})
    public List<WebElement> listOfInitialProductPrices;

    @FindBys({@FindBy(how = How.XPATH, using = "//td[contains(@class, 'product-subtotal')]/span")})
    public List<WebElement> listOfTotalProductPrices;

    @FindBys({@FindBy(how = How.CSS, using = ".input-text.qty")})
    public List<WebElement> listOfProductQuantity;

    @FindBy(how = How.ID, using = "coupon_code")
    public WebElement couponeCode;

    @FindBy(how = How.LINK_TEXT, using = "Apply Coupon")
    public WebElement ApplyCouponButton;

    @FindBy(how = How.LINK_TEXT, using = "Update Cart")
    public WebElement UpdateCartButton;

    @FindBy(how = How.XPATH, using = "//td[@data-title = 'Subtotal']/span")
    public WebElement Subtotal;

    @FindBy(how = How.XPATH, using = "//td[@data-title = 'Total']/strong/span")
    public WebElement Total;

    @FindBy(how = How.LINK_TEXT, using = "Proceed to Checkout")
    public WebElement proceedCheckout;


    public void addProductToCart(String productName ){

    }

    public CartPage(WebDriver driver) {
        super(driver);
    }
}
