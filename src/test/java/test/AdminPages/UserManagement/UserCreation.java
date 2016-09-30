package test.AdminPages.UserManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import ru.yandex.qatools.allure.annotations.Step;
import test.BaseTest;
import util.UserRoles;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserCreation extends BaseTest{

    private LoginPage loginPage;
    private AdminPage adminPage;
    private AdminUserCreation adminUserCreation;
    private AdminUserManagement adminUserManagement;
    private AdminUserDeletion adminUserDeletion;

    private String dateStamp;

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        adminPage = PageFactory.initElements(driver, AdminPage.class);
        adminUserCreation = PageFactory.initElements(driver, AdminUserCreation.class);
        adminUserManagement = PageFactory.initElements(driver, AdminUserManagement.class);
        adminUserDeletion = PageFactory.initElements(driver, AdminUserDeletion.class);
    }

    @BeforeTest
    public void getDateStamp (){
        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        dateStamp = dateFormat.format(date);
    }

    @BeforeMethod
    @Parameters ({"adminUsername", "adminPassword"})
    public void loginAsAdmin (String username, String password){
        loginPage.Open(baseUrl);
        loginPage.LoginAs(username, password);
    }

    @Test
    public void AddUserPageAccess (){
        AddUserLeftPanel();
        adminPage.actionOnMenu("Dashboard", true);
        AddUserTopMenu();
        adminPage.actionOnMenu("Dashboard", true);
        AddUserUsersPage();
    }

    @Test(dependsOnMethods = {"AddUserPageAccess"})
    public void TestUserCreation (){
        //Creates user for each role
        AddUserLeftPanel();
        WebElement username;
        for (UserRoles role : UserRoles.values()){
            adminUserCreation.CreateUser(dateStamp + "_" + role.value(),
                    dateStamp + "_" + role.value() + "@test.com",
                    dateStamp,
                    role.value(),
                    "www." + role.value() + ".com",
                    role.value(),
                    true,
                    role.value());
            //do fast verify
            adminUserManagement.DoSearch(dateStamp + "_" + role.value());
            username = adminUserManagement.userList.get(0).findElement(By.xpath(".//td[@data-colname='Username']/strong/a"));
            Assert.assertTrue(username.getText().contains(dateStamp + "_" + role.value()), "Verify user " + dateStamp + "_" + role.value() + " created");

            //create next user
            adminUserManagement.addNewElement.click();

            //TODO : thoroughly check of created user thru Edit User page
            //adminUserManagement.userList.get(0).findElement(By.xpath(".//td[@data-colname='Username']/strong/a")).click();
        }
    }

    @Test(dependsOnMethods = {"TestUserCreation"}, priority = 0)
    public void DeleteSingleUser (){
        String userToDel = dateStamp + "_" + UserRoles.AUTHOR.value();
        adminPage.actionOnMenu("Users", true);
        Assert.assertTrue(adminUserManagement.DeleteUser(userToDel), "Specify user for deletion.");
        Assert.assertTrue(adminUserDeletion.usersToDelete.getText().contains(userToDel), "Verify right user specified for deletion.");
        adminUserDeletion.SubmitDeletion();
        Assert.assertTrue(adminUserManagement.message.getText().contains("User deleted."), "Verify \"User deleted.\" message appeared");
        adminUserManagement.DoSearch(userToDel);
        Assert.assertTrue(adminUserManagement.searchMessage.getText().contains("No users found."), "Verify deleted user not found.");
    }

    @Test(dependsOnMethods = {"TestUserCreation"}, priority = 1)
    public void DeleteSeveralUsers (){
        String usersToDel = dateStamp + "_";
        adminPage.actionOnMenu("Users", true);
        Assert.assertTrue(adminUserManagement.DeleteUsers(usersToDel), "Specify users for deletion.");
        Assert.assertTrue(adminUserDeletion.usersToDelete.getText().contains(usersToDel), "Verify right users specified for deletion.");
        adminUserDeletion.SubmitDeletion();
        Assert.assertTrue(adminUserManagement.message.getText().contains("users deleted."), "Verify \"User deleted.\" message appeared");
        adminUserManagement.DoSearch(usersToDel);
        Assert.assertTrue(adminUserManagement.searchMessage.getText().contains("No users found."), "Verify deleted user not found.");
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
        Assert.assertTrue (adminUserCreation.headerofTab.getText().contains("Add New User"), "Verify scenario navigated to Add New User page.");
    }
}