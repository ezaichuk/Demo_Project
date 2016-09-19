package test.MainPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
        mainPage.Open(baseUrl);

        mainPage.ClickHomeLink();
        Assert.assertTrue(mainPage.getTitle().contains("Simple shop"), "Verify Home tab is opened.");

        mainPage.ClickCartLink();
        Assert.assertTrue(mainPage.getTitle().contains("Cart"),"Verify Cart tab opened.");

        mainPage.ClickCheckoutLink();
        Assert.assertFalse(mainPage.getTitle().contains("Checkout"), "Verify Checkout tab not opened because there are no goods in cart.");

        mainPage.ClickMyAccountLink();
        Assert.assertTrue(mainPage.getTitle().contains("My account"), "Verify My Account tab is opened.");

        mainPage.ClickNewsLink();
        Assert.assertTrue(mainPage.getTitle().contains("News"), "Verify News tab is opened.");

        mainPage.ClickOurProductsLink();
        Assert.assertTrue(mainPage.getTitle().contains("Products"), "Verify Our Products tab is opened.");
    }

}
