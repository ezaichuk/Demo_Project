package test.MainPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
    public void LoginAsViewerAndLogout(){

        OpenMainPage();
        ClickLoginUrl();
        ViewerLogin();
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
    public void ViewerLogin() {
        loginPage.LoginAs("viewer_as","S2MV%R7*NPCwG7qhCDt8MPQq");
        Assert.assertTrue(mainPage.myAccountContent.getText().contains("Viewer AS"),"Verify login made as Viewer AS.");
    }

    @Step
    public void Logout() {
        mainPage.ClickLogoutLink();
        Assert.assertTrue(loginPage.getTitle().contains("Log In"),"Verify Login page opened.");
        Assert.assertTrue(loginPage.loginMessage.getText().contains("You are now logged out"),"Verify user logged out.");
    }

}
