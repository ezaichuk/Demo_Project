package test.MainPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;
import test.BaseTest;
import util.WebDriverHelper;

import java.io.IOException;

public class LoginPageNegative extends BaseTest{

    private LoginPage loginPage;

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    @Step
    public void InvalidPassword (){
        //ERROR: The password you entered for the username QA is incorrect.
        //link : Lost your password?

        String username = "QA";

        loginPage.Open(baseUrl);
        loginPage.LoginAs(username, "1111");
        WebDriverHelper.WaitTillVisible(loginPage.loginErrorMessage, driver);
        System.out.println(loginPage.loginErrorMessage.getText());
        Assert.assertTrue(loginPage.loginErrorMessage.getText().contains("ERROR: The password you entered for the username " + username + " is incorrect."),
                "Verify wrong password message appeared");
    }

    @Test(dependsOnMethods = {"InvalidPassword"})
    @Step
    public void PasswordRecovery () {
        //placeholder
        Assert.assertTrue(false, "TODO: add password recovery test");
    }

    @Test
    @Step
    public void InvalidUsername (){
        //ERROR: Invalid username.
        loginPage.LoginAs("1111", "1111");
        WebDriverHelper.WaitTillVisible(loginPage.loginErrorMessage, driver);
        System.out.println(loginPage.loginErrorMessage.getText());
        Assert.assertTrue(loginPage.loginErrorMessage.getText().contains("ERROR: Invalid username."),
                "Verify invalid username error message appeared");
    }
}
