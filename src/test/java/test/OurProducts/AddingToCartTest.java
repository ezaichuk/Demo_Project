package test.OurProducts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import pages.CartPage;
import pages.MainPage;
import pages.OurProducts;
import ru.yandex.qatools.allure.annotations.Step;
import test.BaseTest;

/**
 * Created by rgolovatyi on 9/29/2016.
 */
public class AddingToCartTest extends BaseTest {

    private MainPage mainPage;
    private OurProducts ourProducts;
    private CartPage cartPage;

    @BeforeTest
    public void initPageObjects() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        ourProducts = PageFactory.initElements(driver, OurProducts.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
    }

    @Step
    public void OpenOurProductPage(){
        mainPage.Open(baseUrl);
        mainPage.ClickOurProductsLink();
    }

    @Step
    public void AddProductToCart(){

    }
}
