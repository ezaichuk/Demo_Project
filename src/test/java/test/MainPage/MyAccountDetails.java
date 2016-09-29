package test.MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MyAccountAddressesPage;
import pages.MyAccountDetailsPage;
import pages.MyAccountPage;
import test.BaseTest;
import util.WebDriverHelper;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class MyAccountDetails extends BaseTest {

  private MainPage mainPage;
  private MyAccountPage myAccPage;
  private MyAccountDetailsPage accountDetailsPage;
  private MyAccountAddressesPage accountAddressesPage;

  @BeforeMethod
  public void initPageObjects()
  {
    myAccPage = PageFactory.initElements(driver, MyAccountPage.class);
    mainPage = PageFactory.initElements(driver, MainPage.class);
    accountDetailsPage = PageFactory.initElements(driver, MyAccountDetailsPage.class);
    accountAddressesPage = PageFactory.initElements(driver, MyAccountAddressesPage.class);
  }

  @Test
  public void ChangingAccountDetails() {
    //Changing General Account Details
    myAccPage.Open(baseUrl);
    myAccPage.LoginAs("ezaichuk","dferfrfzrhfcjnf");
    myAccPage.OpenAccountDetails();
    accountDetailsPage.SaveGeneralData();

    myAccPage.OpenAccountDetails();

    assertTrue(accountDetailsPage.accDetailsFirstName.getAttribute("value").contains("Eugene1"), "First Name was saved successfully");
    assertTrue(accountDetailsPage.accDetailsLastName.getAttribute("value").contains("Zaichuk1"), "Last Name was saved successfully");
    assertTrue(accountDetailsPage.accDetailsEmail.getAttribute("value").contains("ezaichuk@lohika.com1"), "Email was saved successfully");

    accountDetailsPage.CleanAndRestore();
    myAccPage.Open(baseUrl);
    myAccPage.SignOut();
  }

  //Changing Password
  @Test
  public void ChangingPassword() {
    myAccPage.Open(baseUrl);
    myAccPage.LoginAs("ezaichuk","dferfrfzrhfcjnf");
    myAccPage.OpenAccountDetails();
    accountDetailsPage.SavePassword();
    myAccPage.SignOut();

    myAccPage.LoginAs("ezaichuk","dferfrfzrhfcjnf1");
    assertTrue(driver.getPageSource().contains("not Eugene Zaichuk?"), "Login in by changed password is ok.");
    myAccPage.OpenAccountDetails();
    accountDetailsPage.RestorePassword();
    myAccPage.Open(baseUrl);
    myAccPage.SignOut();
  }

  @Test
  public void ChangingBillingAddress()
  {
    myAccPage.Open(baseUrl);
    myAccPage.LoginAs("ezaichuk","dferfrfzrhfcjnf");
    myAccPage.OpenAddressesLink();

    //has to be refactored
    driver.navigate().to("http://qa-u1604.vlab.lohika.com:8080/my-account/edit-address/billing");
    //

    accountAddressesPage.ChangeBillingAddress();
    myAccPage.OpenAddressesLink();

    //has to be refactored
    driver.navigate().to("http://qa-u1604.vlab.lohika.com:8080/my-account/edit-address/billing");
    //

    assertTrue(accountAddressesPage.accAddressesBillingAFirstName.getAttribute("value").contains("ez1"), "First Name was saved successfully");
    assertTrue(accountAddressesPage.accAddressesBillingALastName.getAttribute("value").contains("11"), "Last Name was saved successfully");
    assertTrue(accountAddressesPage.accAddressesBillingACompanyName.getAttribute("value").contains("Lohika1"), "Company Name was saved successfully");
    assertTrue(accountAddressesPage.accAddressesBillingAMail.getAttribute("value").contains("ezaichuk@lohika.com1"), "E-mail was saved successfully");
    assertTrue(accountAddressesPage.accAddressesBillingAPhone.getAttribute("value").contains("12341"), "Phone was saved successfully");
    assertTrue(accountAddressesPage.accAddressesBillingACountryDropDown.getText().contains("Uganda"), "Country was saved successfully");
    assertTrue(accountAddressesPage.accAddressesBillingAAddress1.getAttribute("value").contains("Odessa city1"), "Address1 was saved successfully");
    assertTrue(accountAddressesPage.accAddressesBillingAAddress2.getAttribute("value").contains("1 Bunina str.1"), "Address2 was saved successfully");
    assertTrue(accountAddressesPage.accAddressesBillingACity.getAttribute("value").contains("Odessa1"), "City was saved successfully");
    assertTrue(accountAddressesPage.accAddressesBillingACounty.getAttribute("value").contains("Besarabia1"), "County was saved successfully");
    assertTrue(accountAddressesPage.accAddressesBillingAZip.getAttribute("value").contains("650001"), "PostalCode was saved successfully");

    accountAddressesPage.RestorePreviousValues();

    myAccPage.SignOut();

  }

}
