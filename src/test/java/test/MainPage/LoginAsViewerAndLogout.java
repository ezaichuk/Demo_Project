package test.MainPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;
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
    public void LoginAsViewerAndLogout(String username, String password){

        OpenMainPage();
        ClickLoginUrl();
        ViewerLogin(username, password);
        Logout();
    }

    @Step
    public void OpenMainPage() {
        mainPage.Open(baseUrl);
        Assert.assertTrue(mainPage.getTitle().contains("virtual-shop"),"Verify Main page opened.");
    }

    @Step
    public void ClickLoginUrl() {
        mainPage.ClickLoginLink();
        Assert.assertTrue(loginPage.getTitle().contains("Log In"),"Verify Login page opened.");
    }

    @Step
    public void ViewerLogin(String username, String password) {
        loginPage.LoginAs(username, password);
        Assert.assertTrue(mainPage.myAccountContent.getText().contains("Hello"),"Verify login made as viewer user.");
    }

    @Step
    public void Logout() {
        mainPage.ClickLogoutLink();
        Assert.assertTrue(loginPage.getTitle().contains("Log In"),"Verify Login page opened.");
        Assert.assertTrue(loginPage.loginMessage.getText().contains("You are now logged out"),"Verify user logged out.");
    }

}