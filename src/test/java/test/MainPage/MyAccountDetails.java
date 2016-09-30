package test.MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MyAccountAddressesPage;
import pages.MyAccountDetailsPage;
import pages.MyAccountPage;
import test.BaseTest;
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
  public void CheckingAccountLinks()
  {
    myAccPage.Open(baseUrl);
    myAccPage.LoginAs("ezaichuk","dferfrfzrhfcjnf");

    myAccPage.ordersLink.click();
    assertTrue(driver.findElement(By.className("entry-title")).getText().contains("Orders"));

    myAccPage.downloadsLink.click();
    assertTrue(driver.findElement(By.className("entry-title")).getText().contains("Downloads"));

    myAccPage.dashboardLink.click();
    assertTrue(driver.findElement(By.className("entry-title")).getText().contains("My account"));

    myAccPage.addressesLink.click();
    assertTrue(driver.findElement(By.className("entry-title")).getText().contains("Addresses"));

    myAccPage.linkAccountDetails.click();
    assertTrue(driver.findElement(By.className("entry-title")).getText().contains("Account Details"));

    myAccPage.logoutLink.click();
    assertTrue(driver.findElement(By.className("entry-title")).getText().contains("My account"));

  }

  @Test
  public void ChangingAccountDetails() {
    //Changing General Account Details
    myAccPage.Open(baseUrl);
    myAccPage.LoginAs("ezaichuk","dferfrfzrhfcjnf");
    myAccPage.OpenAccountDetails();
    //Changing General Data
    accountDetailsPage.ChangeGeneralData("Eugene1","Zaichuk1","ezaichuk@lohika.com1");

    myAccPage.OpenAccountDetails();

    assertTrue(accountDetailsPage.FirstName.getAttribute("value").contains("Eugene1"), "First Name was saved successfully");
    assertTrue(accountDetailsPage.LastName.getAttribute("value").contains("Zaichuk1"), "Last Name was saved successfully");
    assertTrue(accountDetailsPage.Email.getAttribute("value").contains("ezaichuk@lohika.com1"), "Email was saved successfully");

    //Restoring General Data
    accountDetailsPage.ChangeGeneralData("Eugene","Zaichuk","ezaichuk@lohika.com");

    myAccPage.Open(baseUrl);
    myAccPage.SignOut();
  }

  //Changing Password
  @Test
  public void ChangingPassword() {
    myAccPage.Open(baseUrl);
    myAccPage.LoginAs("ezaichuk","dferfrfzrhfcjnf");
    myAccPage.OpenAccountDetails();
    //Changing password to the new one
    accountDetailsPage.ChangePassword("dferfrfzrhfcjnf", "dferfrfzrhfcjnf1", "dferfrfzrhfcjnf1");
    myAccPage.SignOut();

    myAccPage.LoginAs("ezaichuk","dferfrfzrhfcjnf1");
    assertTrue(driver.getPageSource().contains("not Eugene Zaichuk?"), "Login in by changed password is ok.");
    myAccPage.OpenAccountDetails();

    //Restoring password
    accountDetailsPage.ChangePassword("dferfrfzrhfcjnf1", "dferfrfzrhfcjnf", "dferfrfzrhfcjnf");

    myAccPage.Open(baseUrl);
    myAccPage.SignOut();
  }

  @Test
  public void ChangingBillingAddress()
  {
    myAccPage.Open(baseUrl);
    myAccPage.LoginAs("ezaichuk","dferfrfzrhfcjnf");
    myAccPage.OpenAddressesLink();

    accountAddressesPage.billingALink.click();

    //Changing the Billing Address
    accountAddressesPage.ChangeBillingAddress("ez1", "11", "Lohika1", "ezaichuk@lohika.com1", "12341", "Uganda", "Odessa city1",
            "1 Bunina str.1", "Odessa1", "Besarabia1", "650001");

    myAccPage.OpenAddressesLink();
    accountAddressesPage.billingALink.click();

    assertTrue(accountAddressesPage.FirstName.getAttribute("value").contains("ez1"), "First Name was saved successfully");
    assertTrue(accountAddressesPage.LastName.getAttribute("value").contains("11"), "Last Name was saved successfully");
    assertTrue(accountAddressesPage.CompanyName.getAttribute("value").contains("Lohika1"), "Company Name was saved successfully");
    assertTrue(accountAddressesPage.Mail.getAttribute("value").contains("ezaichuk@lohika.com1"), "E-mail was saved successfully");
    assertTrue(accountAddressesPage.Phone.getAttribute("value").contains("12341"), "Phone was saved successfully");
    assertTrue(accountAddressesPage.CountryDropDown.getText().contains("Uganda"), "Country was saved successfully");
    assertTrue(accountAddressesPage.Address1.getAttribute("value").contains("Odessa city1"), "Address1 was saved successfully");
    assertTrue(accountAddressesPage.Address2.getAttribute("value").contains("1 Bunina str.1"), "Address2 was saved successfully");
    assertTrue(accountAddressesPage.City.getAttribute("value").contains("Odessa1"), "City was saved successfully");
    assertTrue(accountAddressesPage.County.getAttribute("value").contains("Besarabia1"), "County was saved successfully");
    assertTrue(accountAddressesPage.Zip.getAttribute("value").contains("650001"), "PostalCode was saved successfully");

    //Restoring the Billing Address
    accountAddressesPage.ChangeBillingAddress("ez", "1", "Lohika", "ezaichuk@lohika.com", "1234", "Ukraine", "Odessa city",
            "1 Bunina str.", "Odessa", "Besarabia", "65000");

    myAccPage.SignOut();

  }

}
