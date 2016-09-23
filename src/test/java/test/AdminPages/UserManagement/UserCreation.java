package test.AdminPages.UserManagement;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.AdminUserCreation;
import pages.AdminUserManagement;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;
import test.BaseTest;

import java.io.IOException;

public class UserCreation extends BaseTest{

    private LoginPage loginPage;
    private AdminPage adminPage;
    private AdminUserCreation adminUserCreation;
    private AdminUserManagement adminUserManagement;

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        adminPage = PageFactory.initElements(driver, AdminPage.class);
        adminUserCreation = PageFactory.initElements(driver, AdminUserCreation.class);
        adminUserManagement = PageFactory.initElements(driver, AdminUserManagement.class);
    }

    @Test
    public void AddUserPageAccess (){
        AdminLogin();
        //NOT WORKING
        /*AddUserLeftPanel();
        adminPage.actionOnMenu("Dashboard", true);*/
        AddUserTopMenu();
        /*adminPage.actionOnMenu("Dashboard", true);
        AddUserUsersPage();*/
    }

    @Test(dependsOnMethods = {"AddUserPageAccess"})
    public void TestUserCreation (){
        adminUserCreation.CreateUser("test", "test@qa.com", "shitpassword");
    }

    @Step
    public void AdminLogin() {
        loginPage.Open(baseUrl);
        loginPage.LoginAs("QA","test");
        Assert.assertTrue(adminPage.getTitle().contains("Dashboard"), "Verify login made as Admin user.");
    }

    @Step
    public void AddUserLeftPanel(){
        adminPage.AddUserLeftPanel();
        Assert.assertTrue (adminUserCreation.headerofTab.getText().contains("Add New User"), "Verify scenario navigated to Add New User page.");
    }
    @Step
    public void AddUserTopMenu(){
        adminPage.AddUserTopMenu();
        Assert.assertTrue (adminUserCreation.headerofTab.getText().contains("Add New User"), "Verify scenario navigated to Add New User page.");
    }

    @Step
    public void AddUserUsersPage(){
        adminPage.actionOnMenu("Users", true);
        adminUserManagement.addNewElement.click();
    }
}
