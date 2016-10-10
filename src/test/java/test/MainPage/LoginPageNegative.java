package test.MainPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import test.BaseTest;

public class LoginPageNegative extends BaseTest{

    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
    }

    @Test
    @Parameters ({"adminUsername"})
    public void invalidPassword(String username){
        loginPage.Open(baseUrl);
        loginPage.LoginAs(username, "1111");
        Assert.assertTrue(loginPage.loginErrorMessage.getText().contains("ERROR: The password you entered for the username " + username + " is incorrect."),
                "Wrong password message appeared");
    }

    @Test(dependsOnMethods = {"invalidPassword"})
    @Parameters ({"adminUsername"})
    public void passwordRecovery(String username) {
        loginPage.LostPasswordClick();
        Assert.assertTrue(myAccountPage.entryTitle.getText().contains("Lost Password"), "User got redirected on Lost Password page.");

        myAccountPage.inputUsernameEmail.sendKeys("1111");
        myAccountPage.buttonResetPassword.click();
        Assert.assertTrue(myAccountPage.loginErrorMessage.getText().contains("Invalid username or e-mail."), "User can\'t get password for nonexistent account.");

        myAccountPage.inputUsernameEmail.sendKeys(username);
        myAccountPage.buttonResetPassword.click();
        Assert.assertTrue(myAccountPage.validMessage.getText().contains("Password reset email has been sent."), "Verify password reset email has been sent.");
    }

    @Test
    public void invalidUsername(){
        loginPage.Open(baseUrl);
        loginPage.LoginAs("1111", "1111");
        Assert.assertTrue(loginPage.loginErrorMessage.getText().contains("ERROR: Invalid username."),
                "Invalid username error message appeared");
    }
}