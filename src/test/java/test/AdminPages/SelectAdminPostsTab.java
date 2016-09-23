package test.AdminPages;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.AdminPageInnerTab;
import pages.LoginPage;
import test.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

/**
 *
 */

public class SelectAdminPostsTab extends BaseTest {

    private LoginPage loginPage;
    private AdminPage adminPage;
    private AdminPageInnerTab adminPageInnerTab;

//    @DataProvider
//    public Object[][] loginPasswordData() {
//        return new Object[][]{
//                new Object[]{"QA", "test"},
////              new Object[] {"some","forCompare"},
//        };
//    }
//    @DataProvider
//        public Object[][] tabs() {
//            return new Object[][] {
//                    new Object[] {"Posts"},
//            };
//    }

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        adminPage = PageFactory.initElements(driver, AdminPage.class);
        adminPageInnerTab = PageFactory.initElements(driver, AdminPageInnerTab.class);
    }

//    @Test(dataProvider = "loginPasswordData")

//    @Parameters({"login", "password","tabName"})
//    @Test
//    public void TestSelectAdminPostsTab(String login, String pass, String tab){
//        loginToAdminPart(login, pass);
//        clickOnPosts(tab);
//        assertThat("Posts tab doesn't  exist ", true, equalTo(true));
//    }


    @Parameters({"login", "password"})
    @Test(priority = 1,alwaysRun =true)
//    @Step
    public void loginToAdminPart(String login, String pass) {

        driver.get(baseUrl + "wp-login.php");
        loginPage.LoginAs(login, pass);
        assertThat("Incorrect Login ... ", adminPage.myAccountMenu.getText(), containsString(login));
    }


    @Parameters({"tabName"})
    //@Test(dependsOnMethods = {"loginToAdminPart"})
    @Test(priority = 2)
//    @Step
    public void clickOnPosts(String tab) {
        adminPage.clickOnNeededTab(tab);
//        adminPagePostsTab.headerofTab.getText();

        assertThat(tab +" tab doesn't  exist ",true,  is(adminPageInnerTab.headerofTab.getText().contains(tab)));
        adminPage.ClickLogoutLink();

    }

}

