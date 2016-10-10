package test.AdminPages.UserManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import test.BaseTest;
import util.UserRoles;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserCreateAndDelete extends BaseTest{

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
    public void addUserPageAccess(){
        //access new user window from left panel
        adminPage.addUserLeftPanel();
        Assert.assertTrue (adminUserCreation.headerofTab.getText().contains("Add New User"), "Scenario navigated to Add New User page.");

        //access new user window from top menu
        adminPage.actionOnMenu("Dashboard", true);
        adminPage.addUserTopMenu();
        Assert.assertTrue (adminUserCreation.headerofTab.getText().contains("Add New User"), "Scenario navigated to Add New User page.");

        //access new user window from user management window
        adminPage.actionOnMenu("Dashboard", true);
        adminPage.actionOnMenu("Users", true);
        adminUserManagement.addNewElement();
        Assert.assertTrue (adminUserCreation.headerofTab.getText().contains("Add New User"), "Scenario navigated to Add New User page.");
    }

    @Test(dependsOnMethods = {"addUserPageAccess"})
    public void userCreation(){
        //test creates user for each role
        adminPage.addUserLeftPanel();
        WebElement username;
        for (UserRoles role : UserRoles.values()){
            adminUserCreation.createUser(dateStamp + "_" + role.value(),
                    dateStamp + "_" + role.value() + "@test.com",
                    dateStamp,
                    role.value(),
                    "www." + role.value() + ".com",
                    role.value(),
                    true,
                    role.value());
            //do fast verify thru user list
            adminUserManagement.doSearch(dateStamp + "_" + role.value());
            username = adminUserManagement.userList.get(0).findElement(By.xpath(".//td[@data-colname='Username']/strong/a"));
            Assert.assertTrue(username.getText().contains(dateStamp + "_" + role.value()), "Verify user " + dateStamp + "_" + role.value() + " created");

            //create next user
            adminUserManagement.addNewElement.click();
        }
    }

    @Test (dependsOnMethods = {"userCreation"})
    public void userDeletion (){
        //delete single author user created in userCreation test
        deleteSingleUser();
        //delete all other users created in userCreation test
        deleteSeveralUsers();
    }

    public void deleteSingleUser(){
        String userToDel = dateStamp + "_" + UserRoles.AUTHOR.value();
        adminPage.actionOnMenu("Users", true);
        Assert.assertTrue(adminUserManagement.deleteUsers(userToDel), "Specify user for deletion.");
        Assert.assertTrue(adminUserDeletion.usersToDelete.getText().contains(userToDel), "Right user specified for deletion.");

        adminUserDeletion.submitDeletion();
        Assert.assertTrue(adminUserManagement.message.getText().contains("User deleted."), "\"User deleted.\" message appeared");

        adminUserManagement.doSearch(userToDel);
        Assert.assertTrue(adminUserManagement.searchMessage.getText().contains("No users found."), "Deleted user not found.");
    }

    public void deleteSeveralUsers(){
        String usersToDel = dateStamp + "_";
        adminPage.actionOnMenu("Users", true);
        Assert.assertTrue(adminUserManagement.deleteUsers(usersToDel), "Specify users for deletion.");
        Assert.assertTrue(adminUserDeletion.usersToDelete.getText().contains(usersToDel), "Right users specified for deletion.");

        adminUserDeletion.submitDeletion();
        Assert.assertTrue(adminUserManagement.message.getText().contains("users deleted."), "\"User deleted.\" message appeared");

        adminUserManagement.doSearch(usersToDel);
        Assert.assertTrue(adminUserManagement.searchMessage.getText().contains("No users found."), "Deleted users not found.");
    }

}