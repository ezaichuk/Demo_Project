package test.MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MyAccountDetailsPage;
import test.BaseTest;
import pages.MainPage;
import pages.MyAccountPage;
import util.WebDriverHelper;

import static org.testng.Assert.*;

public class MyAccountLogin extends BaseTest {

  private MainPage mainPage;
  private MyAccountPage myAccPage;

  @BeforeMethod
  public void initPageObjects() {
    myAccPage = PageFactory.initElements(driver, MyAccountPage.class);
    mainPage = PageFactory.initElements(driver, MainPage.class);
  }

  @Test
  public void LoginAndLogoutSuccess() {
    myAccPage.Open(baseUrl);

    //Login Operation
    myAccPage.LoginAs("ezaichuk","dferfrfzrhfcjnf");
    assertTrue(driver.getPageSource().contains("Eugene Zaichuk"), "Login in by Evgeniy Zaichuk.");

    //doLogout Operation
    myAccPage.SignOut();
    assertFalse(driver.getPageSource().contains("Howdy"), "Sign out is succesfull");

    //Login negative
    myAccPage.LoginAs("ezaichuk2","dferfrfzrhfcjnf");
    assertTrue(driver.findElement(By.xpath(".//ul[@class='woocommerce-error']")).getText().contains("ERROR: Invalid username."), "Login in by non existed user");
  }
}
