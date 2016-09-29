package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rgolovatyi on 9/22/2016.
 */
public class OurProducts extends Page {

    public OurProducts(WebDriver driver) {
        super(driver);
    }

    @FindBys({@FindBy(how = How.CSS, using = ".orderby")})
    public List<WebElement> orderBy;

    @FindBys({@FindBy(how = How.XPATH, using = "//h3")})
    public List<WebElement> listOfProducts;

    @FindBy(how = How.CLASS_NAME, using = "price")
    public WebElement price;

    @FindBy(how = How.CLASS_NAME, using = "page-title")
    public WebElement catalogName;

    public void selectUpperFilter(String ourProductFilter) {
        getUpperProductsFilter().selectByVisibleText(ourProductFilter);
    }

    public Select getUpperProductsFilter() {
        return new Select(this.orderBy.get(0));
    }

    public Select getLowerProductsFilter() {
        return new Select(this.orderBy.get(1));
    }

    private boolean checkProductName(int possition, String name) {
        return this.listOfProducts.get(possition).getText().contains(name);
    }


    public boolean checkProductsNames(List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            if (!checkProductName(i, names.get(i)))
                return false;
        }
        return true;
    }


    public List<String> getProductNames() {
        return listOfProducts.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void addProductToCart(String productName) {
        for (WebElement prod : listOfProducts) {
            if (prod.getText().equals(productName)) {
                prod.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
            }
        }
    }

    public void selectProductOrCatalog(String productName) {

        for (WebElement prod : listOfProducts) {
            String name = prod.getText().replaceAll(" (.*?) .*", " $1");
            if (name.equals(productName)) {
               prod.click();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
