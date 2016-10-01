package test.AdminPages.Posts;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.AdminPageInnerTab;
import pages.LoginPage;
import test.BaseTest;
import util.WebDriverHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

/**
 * Smoke test
 */

public class PostsTabCheckAllSubMenuItems extends BaseTest {

    private LoginPage loginPage;
    private AdminPage adminPage;
    private AdminPageInnerTab adminPageInnerTab;

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
            {"Tags", "Tags"},
            {"Categories", "Categories"},
            {"Add New", "Add New Post"},
            {"All Posts", "Posts"}
    };
}

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        adminPage = PageFactory.initElements(driver, AdminPage.class);
        adminPageInnerTab = PageFactory.initElements(driver, AdminPageInnerTab.class);
    }

    @Parameters({"login", "password"})
    @Test(priority = 1,alwaysRun =true)
    public void loginToAdminPart(String login, String pass) {
        driver.get(baseUrl + "wp-login.php");
        loginPage.LoginAs(login, pass);
        assertThat("Incorrect Login ... ", adminPage.myAccountMenu.getText(), containsString(login));
    }

    @Parameters({"tabName"})
    @Test(dependsOnMethods = {"loginToAdminPart"}, priority = 2)
    public void clickOnPosts(String tab) {
        adminPage.postsMenu.click();
        assertThat(tab +" tab doesn't  exist ",adminPageInnerTab.headerofTab.getText(), containsString(tab));
    }

    @Test(dependsOnMethods = {"loginToAdminPart"}, priority = 3, dataProvider="data")
    public void clickOnSubMenuItemInPosts(String submenuItem, String submenuItemHeaderText) {
        adminPage.SubMenuItem(adminPage.postsMenu,submenuItem);
        assertThat(" tab doesn't  exist ",adminPageInnerTab.headerofTab.getText(), containsString(submenuItemHeaderText));
    }

    @Test(dependsOnMethods = {"loginToAdminPart"}, priority = 4, dataProvider="data")
    public void clickOnSubMenuItemInPostsOverMouseOver (String submenuItem, String submenuItemHeaderText) {
        adminPage.dashboardMenu.click();
        WebDriverHelper.MouseOver(adminPage.postsMenu,driver);
        adminPage.SubMenuItem(adminPage.postsMenu,submenuItem);
        assertThat(" tab doesn't  exist ",adminPageInnerTab.headerofTab.getText(), containsString(submenuItemHeaderText));
    }

    @Parameters({"loggedOutMessage"})
    @Test(dependsOnMethods = {"loginToAdminPart"}, priority = 5)
    public void logoutFromAdminPart(String loggedOutMessage){
        adminPage.ClickLogoutLink();
        assertThat("You are not correctly logged out",loginPage.loginMessage.getText(),is(loggedOutMessage));
    }
}

