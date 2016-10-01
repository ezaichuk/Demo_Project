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
 * Created by dbolgarov on 9/25/2016.
 */
public class PostTabAddNewPostByButton extends BaseTest {
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

    @Parameters({"tabName","addNewElementText"})
    @Test(dependsOnMethods = {"loginToAdminPart"}, priority = 2)
    public void clickOnPosts(String tab,String addNewElementText) {
        adminPage.clickOnNeededTab(tab);
        assertThat(tab +" tab doesn't  exist ",adminPageInnerTab.headerofTab.getText(), containsString(tab));
        assertThat("Incorrect text for  Add New button in Add New Post tab",adminPageInnerTab.addNewElement.getText(), is(addNewElementText));
    }

    @Parameters({"addNewPostHeaderText"})
    @Test(dependsOnMethods = {"loginToAdminPart"}, priority = 3)
    public void openNewPostFrame(String addNewPostHeaderText) {
        adminPageInnerTab.addNewElement.click();
        assertThat("Add New Post tab didn't open ",adminPageInnerTab.headerofTab.getText(), is(addNewPostHeaderText));
    }

    @Parameters({"titlePromptText","insertMediaButton","wordCountLabel","postStatusLabel","publishButtonText"})
    @Test(dependsOnMethods = {"loginToAdminPart"}, priority = 4)
    public void checkAllNamesInNewPostFrameBeforePublish( String titlePromptText, String insertMediaButton, String wordCountLabel, String postStatusLabel,String publishButtonText) {
        assertThat("Incorrect prompt for title in Add New Post tab",adminPageInnerTab.titlePromptText.getText(),is(titlePromptText));
        assertThat("Incorrect text for Add Media button in Add New Post tab",adminPageInnerTab.insertMediaButton.getText(), is(insertMediaButton));
        assertThat("Incorrect text for word count field in Add New Post tab",adminPageInnerTab.wordCountLabel.getText(), is(wordCountLabel));
        assertThat("Incorrect text for post status field in Add New Post tab",adminPageInnerTab.postStatusLabel.getText(), is(postStatusLabel));
        assertThat("Incorrect text for publish button in Add New Post tab",adminPageInnerTab.publishOrUpdateButton.getAttribute("value"), is(publishButtonText));
    }

    @Parameters({"titleToAddNewPost","bodyToAddNewPost","publishTextForMessageBox","statusFieldText", "updateButtonText", "addNewPostHeaderTextEditPost", "addNewElementText","login"})
    @Test(dependsOnMethods = {"loginToAdminPart"}, priority = 5)
    public void AddNewPost(String titleToAddNewPost, String bodyToAddNewPost, String publishTextForMessageBox, String statusFieldText, String updateButtonText, String addNewPostHeaderTextEditPost, String addNewElementText, String login) {
        adminPageInnerTab.AddNewPost(titleToAddNewPost,bodyToAddNewPost, this.getClass().getSimpleName());
        assertThat("Word count is not  correct",Integer.parseInt(adminPageInnerTab.wordCountNumber.getText()),is(bodyToAddNewPost.split("\\s+").length+1));
        assertThat("New Post tab didn't published",adminPageInnerTab.statusField.getText(), is(statusFieldText));
        assertThat("New Post tab didn't published. Check publishOrUpdateMessageBox",adminPageInnerTab.publishOrUpdateMessageBox.getText(), is(publishTextForMessageBox));
        assertThat("Incorrect text for update button in Add New Post tab",  adminPageInnerTab.publishOrUpdateButton.getAttribute("value"), is(updateButtonText));
        assertThat("Incorrect text for header in Add New Post tab",adminPageInnerTab.headerofTab.getText(), containsString(addNewPostHeaderTextEditPost));
        assertThat("Incorrect text for  Add New button in Add New Post tab",adminPageInnerTab.addNewElement.getText(), is(addNewElementText));
        assertThat("Incorrect text information in last Edit element - incorrect author",adminPageInnerTab.lastEdit.getText(),containsString(login));
        assertThat("Incorrect text information in last Edit element - incorrect date of publish",adminPageInnerTab.lastEdit.getText(), containsString(WebDriverHelper.stringToDateConvert(adminPageInnerTab.postTimestamp.getText(), null, "MMMM d, yyyy 'at' h:mm")));
    }

    @Parameters({"loggedOutMessage"})
    @Test(dependsOnMethods = {"loginToAdminPart"}, priority = 6)
    public void logoutFromAdminPart(String loggedOutMessage){
        adminPage.ClickLogoutLink();
        assertThat("You are not correctly logged out",loginPage.loginMessage.getText(),is(loggedOutMessage));
    }
}
