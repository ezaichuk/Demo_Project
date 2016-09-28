package test.AdminPages.UserManagement;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;
import ru.yandex.qatools.allure.annotations.Step;
import test.BaseTest;
import util.UserRoles;

import java.io.IOException;

public class UserCreation extends BaseTest{

    private LoginPage loginPage;
    private AdminPage adminPage;
    private AdminUserCreation adminUserCreation;
    private AdminUserManagement adminUserManagement;
    private AdminUserDeletion adminUserDeletion;

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        adminPage = PageFactory.initElements(driver, AdminPage.class);
        adminUserCreation = PageFactory.initElements(driver, AdminUserCreation.class);
        adminUserManagement = PageFactory.initElements(driver, AdminUserManagement.class);
        adminUserDeletion = PageFactory.initElements(driver, AdminUserDeletion.class);
    }

    @Test
    public void AddUserPageAccess (){
        AdminLogin();
        AddUserLeftPanel();
        adminPage.actionOnMenu("Dashboard", true);
        AddUserTopMenu();
        adminPage.actionOnMenu("Dashboard", true);
        AddUserUsersPage();
    }

    @Test(dependsOnMethods = {"AddUserPageAccess"})
    public void TestUserCreation (){
        //Creates user for each role
        WebElement username;
        for (UserRoles role : UserRoles.values()){
            adminUserCreation.CreateUser("test_" + role.value(),
                    "test_" + role.value() + "@test.com",
                    "test",
                    role.value(),
                    "www." + role.value() + ".com",
                    role.value(),
                    true,
                    role.value());
            //do fast verify
            adminUserManagement.DoSearch("test_" + role.value());
            username = adminUserManagement.userList.get(0).findElement(By.xpath(".//td[@data-colname='Username']/strong/a"));
            Assert.assertTrue(username.getText().contains("test_" + role.value()), "Verify user " + "test_" + role.value() + " created");

            //create next user
            adminUserManagement.addNewElement.click();

            //TODO : thoroughly check of created user thru Edit User page
            //adminUserManagement.userList.get(0).findElement(By.xpath(".//td[@data-colname='Username']/strong/a")).click();
        }
    }

    @Test//(dependsOnMethods = {"TestUserCreation"})
    public void DeleteSingleUser (){
        AdminLogin();
        String usertodel = "test_subscriber";
        adminPage.actionOnMenu("Users", true);
        Assert.assertTrue(adminUserManagement.DeleteUser(usertodel), "Specify user for deletion.");
        Assert.assertTrue(adminUserDeletion.usersToDelete.getText().contains(usertodel), "Verify right user specified for deletion.");
        adminUserDeletion.SubmitDeletion();
        Assert.assertTrue(adminUserManagement.message.getText().contains("User deleted."), "Verify \"User deleted.\" message appeared");
        adminUserManagement.DoSearch(usertodel);
        Assert.assertTrue(adminUserManagement.searchMessage.getText().contains("No users found."), "Verify deleted user not found.");
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
