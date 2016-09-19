package test.MainPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
    public void OpenMainPage() {
        mainPage.Open(baseUrl);
        Assert.assertTrue(mainPage.getTitle().contains("virtual-shop"), "Verify Main page opened.");
    }

    @Test(dependsOnMethods = {"OpenMainPage"})
    public void ClickLoginUrl() {
        mainPage.ClickLoginLink();
        Assert.assertTrue(loginPage.getTitle().contains("Log In"),"Verify Login page opened.");
    }

    @Test(dependsOnMethods = {"ClickLoginUrl"})
    public void AdminLogin() {
        loginPage.LoginAs("QA","test");
        Assert.assertTrue(adminPage.getTitle().contains("Dashboard"),"Verify login made as Admin user.");
    }

    @Test(dependsOnMethods = {"AdminLogin"})
    public void Logout() {
        adminPage.ClickLogoutLink();
        Assert.assertTrue(loginPage.getTitle().contains("Log In"),"Verify Login page opened.");
        Assert.assertTrue(loginPage.loginMessage.getText().contains("You are now logged out"),"Verify user logged out.");
    }

}
