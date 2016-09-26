package test.MainPage;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.LoginPage;
import test.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 *
 */

public class LoginAs extends BaseTest {

    private LoginPage loginPage;
    private AdminPage adminPage;

    @DataProvider
    public Object[][] loginPasswordData() {
        return new Object[][] {
                new Object[] {"QA","test"},
//              new Object[] {"some","forCompare"},

        };
    }

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        adminPage = PageFactory.initElements(driver, AdminPage.class);
    }

    @Test( dataProvider = "loginPasswordData")
    public void loginToAdminPart(String login, String pass) {

        driver.get(baseUrl+"wp-login.php");

        loginPage.LoginAs(login, pass);


        assertThat("Incorrect Login ... ", adminPage.myAccountMenu.getText(), containsString(login));


    }
}

