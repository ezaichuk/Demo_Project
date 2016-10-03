package test.OurProducts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProductsPage;
import pages.examplePage;
import ru.yandex.qatools.allure.annotations.Step;
import test.BaseTest;

public class ProductsAdvanced extends BaseTest {

    private MainPage mainPage;
    private ProductsPage productsPage;
    private examplePage homepage;
    private LoginPage loginPage;


    @BeforeMethod
    public void initPageObjects() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        productsPage = PageFactory.initElements(driver, ProductsPage.class);
        homepage = PageFactory.initElements(driver, examplePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void OurProductsAdvancedTests(){

        OpenLoginPage();
        ViewerLogin();
        OpenProductsPage();
        SearchForProduct();
        DrillToProduct();
        Logout();
    }

    @Step
    public void OpenLoginPage() {
        mainPage.Open(baseUrl + "wp-login.php");
        Assert.assertTrue(mainPage.getTitle().contains("virtual-shop"), "Verify Main page opened.");
    }

    @Step
    public void ViewerLogin() {
        loginPage.LoginAs("viewer_as", "P@ssw0rd");
        Assert.assertTrue(mainPage.myAccountContent.getText().contains("not Viewer AS"),"Verify login made as Viewer AS.");
    }

    @Step
    public void OpenProductsPage() {
        productsPage.Open(baseUrl + "/shop/");
        Assert.assertTrue(mainPage.getTitle().contains("Products"), "Verifying correct page [Products] is opened.");
    }

    @Step
    public void SearchForProduct() {
        productsPage.PerformSearch("Coin");
        Assert.assertTrue("Search Results for: Coin".equals(homepage.header.getText()), "Checking header label.");
    }

    @Step
    private void DrillToProduct() {
        productsPage.ClickItemLink();
        Assert.assertEquals(productsPage.relatedProducts.getText(), "Related Products", "Verifying related products section.");
    }

    @Step
    public void Logout() {
        mainPage.ClickLogoutLink();
        Assert.assertTrue(loginPage.getTitle().contains("Log In"),"Verify Login page opened.");
        Assert.assertTrue(loginPage.loginMessage.getText().contains("You are now logged out"),"Verify user logged out.");
    }

}
