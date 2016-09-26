package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

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

    @FindBys({@FindBy(how = How.XPATH, using = "//*[@id='main']//h3")})
    public List<WebElement> listOfProducts;

    @FindBy(how = How.CLASS_NAME, using = "price")
    public WebElement price;

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


}
