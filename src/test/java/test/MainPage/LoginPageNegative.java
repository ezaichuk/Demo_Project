package test.MainPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import ru.yandex.qatools.allure.annotations.Step;
import test.BaseTest;
import util.WebDriverHelper;

import java.io.IOException;

public class LoginPageNegative extends BaseTest{

    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
    }

    @Test
    @Step
    @Parameters ({"adminUsername"})
    public void InvalidPassword (String username){
        //ERROR: The password you entered for the username QA is incorrect.
        //link : Lost your password?

        loginPage.Open(baseUrl);
        loginPage.LoginAs(username, "1111");
        WebDriverHelper.WaitTillVisible(loginPage.loginErrorMessage, driver);
        System.out.println(loginPage.loginErrorMessage.getText());
        Assert.assertTrue(loginPage.loginErrorMessage.getText().contains("ERROR: The password you entered for the username " + username + " is incorrect."),
                "Verify wrong password message appeared");
    }

    @Test(dependsOnMethods = {"InvalidPassword"})
    @Step
    @Parameters ({"adminUsername"})
    public void PasswordRecovery (String username) {
        loginPage.LostPasswordClick();
        Assert.assertTrue(myAccountPage.entryTitle.getText().contains("Lost Password"), "Verify user got redirected on Lost Password page.");

        myAccountPage.inputUsernameEmail.sendKeys("1111");
        myAccountPage.buttonResetPassword.click();
        Assert.assertTrue(myAccountPage.loginErrorMessage.getText().contains("Invalid username or e-mail."), "Verify user can\'t get password for nonexistent account.");

        myAccountPage.inputUsernameEmail.sendKeys(username);
        myAccountPage.buttonResetPassword.click();
        Assert.assertTrue(myAccountPage.validMessage.getText().contains("Password reset email has been sent."), "Verify password reset email has been sent.");
    }

    @Test
    @Step
    public void InvalidUsername (){
        //ERROR: Invalid username.
        loginPage.Open(baseUrl);
        loginPage.LoginAs("1111", "1111");
        WebDriverHelper.WaitTillVisible(loginPage.loginErrorMessage, driver);
        System.out.println(loginPage.loginErrorMessage.getText());
        Assert.assertTrue(loginPage.loginErrorMessage.getText().contains("ERROR: Invalid username."),
                "Verify invalid username error message appeared");
    }
}