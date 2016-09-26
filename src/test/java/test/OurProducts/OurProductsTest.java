package test.OurProducts;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OurProducts;
import ru.yandex.qatools.allure.annotations.Step;
import test.BaseTest;
import util.OurProductFilter;



/**
 * Created by rgolovatyi on 9/22/2016.
 */
public class OurProductsTest extends BaseTest {
    private MainPage mainPage;
    private OurProducts ourProducts;

    @BeforeMethod
    public void initPageObjects() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        ourProducts = PageFactory.initElements(driver, OurProducts.class);
    }


    @Test()
    public void selectProduct() {
        openOurProductPage();
        selectAndCheckFilters();
        checkProductsNames();
    }


    @Step
    public void openOurProductPage() {
        mainPage.Open(baseUrl);
        mainPage.ClickOurProductsLink();
    }

    @Step
    public void selectAndCheckFilters() {
        ourProducts.selectUpperFilter(OurProductFilter.DATE.getValue());
        Assert.assertTrue(ourProducts.getUpperProductsFilter().getFirstSelectedOption().getText().contains(OurProductFilter.DATE.getValue()));
        Assert.assertTrue(ourProducts.getLowerProductsFilter().getFirstSelectedOption().getText().contains(OurProductFilter.DATE.getValue()));

    }

    @Step
    public void checkProductsNames() {
        Assert.assertTrue(ourProducts.checkProductsNames(ourProducts.getProductNames()));
    }

}



