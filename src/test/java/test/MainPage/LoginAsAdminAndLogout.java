package test.MainPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import pages.MainPage;
import test.BaseTest;

public class LoginAsAdminAndLogout extends BaseTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private AdminPage adminPage;

    @BeforeMethod
    public void initPageObjects() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        adminPage = PageFactory.initElements(driver, AdminPage.class);
    }

    @Test
    @Parameters({"adminUsername", "adminPassword"})
    public void loginAsAdminAndLogout (String username, String password){
        mainPage.Open(baseUrl);
        Assert.assertTrue(mainPage.getTitle().contains("virtual-shop"), "Main page opened.");

        mainPage.ClickLoginLink();
        Assert.assertTrue(loginPage.getTitle().contains("Log In"),"Login page opened.");

        loginPage.LoginAs(username, password);
        Assert.assertTrue(adminPage.getTitle().contains("Dashboard"),"Login made as administrator user.");

        adminPage.ClickLogoutLink();
        Assert.assertTrue(loginPage.getTitle().contains("Log In"),"Login page opened.");
        Assert.assertTrue(loginPage.loginMessage.getText().contains("You are now logged out"),"User logged out.");
    }
}