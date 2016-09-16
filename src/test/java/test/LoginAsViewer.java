package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

public class LoginAsViewer extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    public void initPageObjects() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void OpenMainPage() {
        mainPage.Open(baseUrl);
        Assert.assertTrue(mainPage.getTitle().contains("virtual-shop"),"Verify Main page opened.");
    }

    @Test(dependsOnMethods = {"OpenMainPage"})
    public void ClickLoginUrl() {
        mainPage.ClickLoginLink();
        Assert.assertTrue(mainPage.getTitle().contains("Log In"),"Verify Login page opened.");
    }

}
