package test.MainPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import test.BaseTest;

public class CheckTopLinksMainPage extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    public void initPageObjects() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void CheckTopLinks() {

        SoftAssert softAssert = new SoftAssert();

        mainPage.Open(baseUrl);

        mainPage.ClickHomeLink();
        softAssert.assertTrue(mainPage.getTitle().contains("Simple shop"), "Home tab is opened.");

        mainPage.ClickCartLink();
        softAssert.assertTrue(mainPage.getTitle().contains("Cart"),"Cart tab opened.");

        mainPage.ClickCheckoutLink();
        softAssert.assertFalse(mainPage.getTitle().contains("Checkout"), "Checkout tab not opened, because there are no goods in cart.");

        mainPage.ClickMyAccountLink();
        softAssert.assertTrue(mainPage.getTitle().contains("My account"), "My Account tab is opened.");

        mainPage.ClickNewsLink();
        softAssert.assertTrue(mainPage.getTitle().contains("News"), "News tab is opened.");

        mainPage.ClickOurProductsLink();
        softAssert.assertTrue(mainPage.getTitle().contains("Products"), "Our Products tab is opened.");

        softAssert.assertAll();
    }

}
