package test.AdminPages.Posts;

import org.openqa.selenium.JavascriptExecutor;
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
 * Created by dbolgarov on 9/25/2016.
 */
public class PostTabAddNewPostByUrl extends BaseTest {
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
//    @Step
    public void loginToAdminPart(String login, String pass) {

//       loginPage.Open("http://qa-u1604.vlab.lohika.com:8080/wp-admin/post-new.php");
        driver.get("http://qa-u1604.vlab.lohika.com:8080/wp-admin/post-new.php");
        loginPage.LoginAs(login, pass);
        assertThat("Incorrect Login ... ", adminPage.myAccountMenu.getText(), containsString(login));
    }

    @Parameters({"addNewPostHeaderText"})
    @Test(priority = 2)
    public void clickOnNewPostViaPlusMenu(String addNewPostHeaderText) {
       assertThat(" Add New Post Dialog didn't open",true,  is(adminPageInnerTab.headerofTab.getText().contains(addNewPostHeaderText)));

    }



    @Test(priority = 6)
    public void AddNewPost() {
        adminPageInnerTab.addNewItemName.sendKeys("Test title for  new post by URL");

        driver.switchTo().frame(adminPageInnerTab.innerFrame);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].innerHTML = '"+ "Some text in the post by URL" +"'", adminPageInnerTab.addNewItemBodyText);
        driver.switchTo().defaultContent();
        adminPageInnerTab.publishOrUpdateButton.click();

        assertThat("Add New Post tab didn't open ",true,  is(adminPageInnerTab.statusField.getText().contains("Published")));
        adminPage.ClickLogoutLink();
    }
}
