package test.MainPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import test.BaseTest;

public class LoginAsViewerAndLogout extends BaseTest {

    private MainPage mainPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void initPageObjects() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    @Parameters({"viewerUsername", "viewerPassword"})
    public void loginAsViewerAndLogout(String username, String password){

        mainPage.Open(baseUrl);
        Assert.assertTrue(mainPage.getTitle().contains("virtual-shop"),"Main page opened.");

        mainPage.ClickLoginLink();
        Assert.assertTrue(loginPage.getTitle().contains("Log In"),"Login page opened.");

        loginPage.LoginAs(username, password);
        Assert.assertTrue(mainPage.myAccountContent.getText().contains("Hello"),"Login made as viewer user.");

        mainPage.ClickLogoutLink();
        Assert.assertTrue(loginPage.getTitle().contains("Log In"),"Login page opened.");
        Assert.assertTrue(loginPage.loginMessage.getText().contains("You are now logged out"),"User logged out.");

    }
}