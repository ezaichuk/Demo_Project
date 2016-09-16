package test.MainPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
    public void OpenMainPage() {
        mainPage.Open(baseUrl);
        Assert.assertTrue(mainPage.getTitle().contains("virtual-shop"),"Verify Main page opened.");
    }

    @Test(dependsOnMethods = {"OpenMainPage"})
    public void ClickLoginUrl() {
        mainPage.ClickLoginLink();
        Assert.assertTrue(loginPage.getTitle().contains("Log In"),"Verify Login page opened.");
    }

    @Test(dependsOnMethods = {"ClickLoginUrl"})
    public void ViewerLogin() {
        loginPage.LoginAs("viewer_as","S2MV%R7*NPCwG7qhCDt8MPQq");
        Assert.assertTrue(mainPage.myAccountContent.getText().contains("Viewer AS"),"Verify login made as Viewer AS.");
    }

    @Test(dependsOnMethods = {"ViewerLogin"})
    public void Logout() {
        mainPage.ClickLogoutLink();
        Assert.assertTrue(loginPage.getTitle().contains("Log In"),"Verify Login page opened.");
    }

}
