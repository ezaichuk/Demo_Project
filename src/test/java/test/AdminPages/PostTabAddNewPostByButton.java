package test.AdminPages;

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

    }

    @Test(priority = 3)
    public void openNewPostFrame() {
    adminPageInnerTab.addNewElement.click();
        assertThat("Add New Post tab didn't open ",true,  is(adminPageInnerTab.headerofTab.getText().contains("Add New Post")));
    }

    @Test(priority = 4)
    public void AddNewPost() {
        adminPageInnerTab.addNewItemName.sendKeys("Test title for  new post");

        driver.switchTo().frame(adminPageInnerTab.innerFrame);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].innerHTML = '"+ "Some text in the post" +"'", adminPageInnerTab.addNewItemBodyText);
        driver.switchTo().defaultContent();
        adminPageInnerTab.publishOrUpdateButton.click();
        assertThat("Add New Post tab didn't open ",true,  is(adminPageInnerTab.statusField.getText().contains("Published")));
        adminPage.ClickLogoutLink();
    }
}
