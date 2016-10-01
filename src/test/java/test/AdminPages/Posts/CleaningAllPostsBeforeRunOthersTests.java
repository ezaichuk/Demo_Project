package test.AdminPages.Posts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
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
 * Initial test - Cleaning all posts
 */
public class CleaningAllPostsBeforeRunOthersTests extends BaseTest {

    private LoginPage loginPage;
    private AdminPage adminPage;
    private AdminPageInnerTab adminPageInnerTab;

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

    @Parameters({"tabName", "submenuAllPostsItem"})
    @Test(dependsOnMethods = {"loginToAdminPart"}, priority = 2)
    public void clickOnPostsMenu(String tabName, String submenuAllPostsItem) {
        WebDriverHelper.MouseOver(adminPage.postsMenu,driver);
        adminPage.SubMenuItem(adminPage.postsMenu,submenuAllPostsItem);
        assertThat(" Add New Post Dialog didn't open",adminPageInnerTab.headerofTab.getText(), containsString(tabName));
    }

    @Parameters({"selectorBulkActionsMoveToTrash"})
    @Test(dependsOnMethods = {"loginToAdminPart"}, priority = 3)
    public void cleanAllPosts(String selectorBulkActionsMoveToTrash) {
        int numberOfAllPosts = Integer.parseInt(adminPageInnerTab.countOfAllPosts.getText().substring(1, adminPageInnerTab.countOfAllPosts.getText().length() - 1));
        if (numberOfAllPosts != 0) {
            adminPageInnerTab.checkboxSelectAllPosts.click();
            WebDriverHelper.selectOptionInDropdownMenu(adminPageInnerTab.selectorBulkActions, selectorBulkActionsMoveToTrash);
            adminPageInnerTab.applyButtonInPosts.click();
            assertThat("Incorrect text in message box", adminPageInnerTab.publishOrUpdateMessageBox.getText(), containsString(numberOfAllPosts + " post"));
//            assertThat("Incorrect number of posts in trash",Integer.parseInt(adminPageInnerTab.countOfPostsInTrash.getText().substring(1, adminPageInnerTab.countOfPostsInTrash.getText().length()-1)), is(numberOfAllPosts));
            adminPageInnerTab.countOfPostsInTrash.click();
            adminPageInnerTab.emptyTrashButtonInPosts.click();
        } else {
            if (WebDriverHelper.isElementPresent(adminPageInnerTab.countOfPostsInTrash)) {
                adminPageInnerTab.countOfPostsInTrash.click();
                adminPageInnerTab.emptyTrashButtonInPosts.click();
            } else {
                System.out.println("!!!! Already done !!!!");
            }
        }
    }

    @Parameters({"loggedOutMessage"})
    @Test(dependsOnMethods = {"loginToAdminPart"}, priority = 6)
    public void logoutFromAdminPart(String loggedOutMessage){
        adminPage.ClickLogoutLink();
        assertThat("You are not correctly logged out",loginPage.loginMessage.getText(),is(loggedOutMessage));
    }
}
