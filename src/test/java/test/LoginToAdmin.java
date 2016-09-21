package test;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AdminConsole;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 *
 */

public class LoginToAdmin extends BaseTest {

    private LoginPage loginPage;
    private AdminConsole adminConsole;

    @DataProvider
    public Object[][] loginPasswordData() {
        return new Object[][] {
                new Object[] {"QA","test"},
//                new Object[] {"some","forCompare"},

        };
    }

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        adminConsole = PageFactory.initElements(driver, AdminConsole.class);
    }

    @Test( dataProvider = "loginPasswordData")
    public void loginToAdminPart(String login, String pass) {
        driver.get(baseUrl+"wp-login.php");

        loginPage.Login(login, pass);

//        assertThat("Incorrect Logout ... ", adminConsole.loggedUserBox.getText() , containsString(login));
        assertThat("Incorrect Logout ... ", adminConsole.loggedUserBox().getText() , containsString(login));


    }
}

