package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class MyAccountAddressesPage extends Page {

    //@FindBy(how = How.XPATH, using = ".//div[@class='u-column1 col-1 woocommerce-Address']/")
    //public WebElement accAddressesBillingALink;

    @FindBy(how = How.NAME, using = "billing_first_name")
    public WebElement accAddressesBillingAFirstName;

    @FindBy(how = How.NAME, using = "billing_last_name")
    public WebElement accAddressesBillingALastName;

    @FindBy(how = How.NAME, using = "billing_company")
    public WebElement accAddressesBillingACompanyName;

    @FindBy(how = How.NAME, using = "billing_email")
    public WebElement accAddressesBillingAMail;

    @FindBy(how = How.NAME, using = "billing_phone")
    public WebElement accAddressesBillingAPhone;

    //Shity dropdownlist
    @FindBy(how = How.ID, using = "select2-chosen-1")
    public WebElement accAddressesBillingACountryDropDown;
    @FindBy(how = How.CLASS_NAME, using = "select2-input")
    public WebElement accAddressesBillingACountryDropDownInput;
    @FindBy(how = How.CLASS_NAME, using = "select2-result-label")
    public WebElement accAddressesBillingACountryDropDownOption;
    //

    @FindBy(how = How.NAME, using = "billing_address_1")
    public WebElement accAddressesBillingAAddress1;

    @FindBy(how = How.NAME, using = "billing_address_2")
    public WebElement accAddressesBillingAAddress2;

    @FindBy(how = How.NAME, using = "billing_city")
    public WebElement accAddressesBillingACity;

    @FindBy(how = How.NAME, using = "billing_state")
    public WebElement accAddressesBillingACounty;

    @FindBy(how = How.NAME, using = "billing_postcode")
    public WebElement accAddressesBillingAZip;

    @FindBy(how = How.NAME, using = "save_address")
    public WebElement accAddressesBillingASaveButton;


    public void ChangeBillingAddress(){

        accAddressesBillingAFirstName.clear();
        accAddressesBillingALastName.clear();
        accAddressesBillingACompanyName.clear();
        accAddressesBillingAMail.clear();
        accAddressesBillingAPhone.clear();
        accAddressesBillingAAddress1.clear();
        accAddressesBillingAAddress2.clear();
        accAddressesBillingACity.clear();
        accAddressesBillingACounty.clear();
        accAddressesBillingAZip.clear();

        accAddressesBillingAFirstName.sendKeys("ez1");
        accAddressesBillingALastName.sendKeys("11");
        accAddressesBillingACompanyName.sendKeys("Lohika1");
        accAddressesBillingAMail.sendKeys("ezaichuk@lohika.com1");
        accAddressesBillingAPhone.sendKeys("12341");

        //Working with shity dropdownlist
        accAddressesBillingACountryDropDown.click();
        accAddressesBillingACountryDropDownInput.sendKeys("Uganda");
        accAddressesBillingACountryDropDownOption.click();
        //

        accAddressesBillingAAddress1.sendKeys("Odessa city1");
        accAddressesBillingAAddress2.sendKeys("1 Bunina str.1");
        accAddressesBillingACity.sendKeys("Odessa1");
        accAddressesBillingACounty.sendKeys("Besarabia1");
        accAddressesBillingAZip.sendKeys("650001");

        accAddressesBillingASaveButton.click();
    }

    public void RestorePreviousValues()
    {

        accAddressesBillingAFirstName.clear();
        accAddressesBillingALastName.clear();
        accAddressesBillingACompanyName.clear();
        accAddressesBillingAMail.clear();
        accAddressesBillingAPhone.clear();
        accAddressesBillingAAddress1.clear();
        accAddressesBillingAAddress2.clear();
        accAddressesBillingACity.clear();
        accAddressesBillingACounty.clear();
        accAddressesBillingAZip.clear();

        accAddressesBillingAFirstName.sendKeys("ez");
        accAddressesBillingALastName.sendKeys("1");
        accAddressesBillingACompanyName.sendKeys("Lohika");
        accAddressesBillingAMail.sendKeys("ezaichuk@lohika.com");
        accAddressesBillingAPhone.sendKeys("1234");

        //Working with shity dropdownlist
        accAddressesBillingACountryDropDown.click();
        accAddressesBillingACountryDropDownInput.sendKeys("Ukraine");
        accAddressesBillingACountryDropDownOption.click();
        //

        accAddressesBillingAAddress1.sendKeys("Odessa city");
        accAddressesBillingAAddress2.sendKeys("1 Bunina str.");
        accAddressesBillingACity.sendKeys("Odessa");
        accAddressesBillingACounty.sendKeys("Besarabia");
        accAddressesBillingAZip.sendKeys("65000");

        accAddressesBillingASaveButton.click();
    }

    public MyAccountAddressesPage(WebDriver driver) {
        super(driver);
    }
}
