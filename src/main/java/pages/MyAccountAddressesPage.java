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
    public WebElement FirstName;

    @FindBy(how = How.NAME, using = "billing_last_name")
    public WebElement LastName;

    @FindBy(how = How.NAME, using = "billing_company")
    public WebElement CompanyName;

    @FindBy(how = How.NAME, using = "billing_email")
    public WebElement Mail;

    @FindBy(how = How.NAME, using = "billing_phone")
    public WebElement Phone;

    //Shity dropdownlist
    @FindBy(how = How.ID, using = "select2-chosen-1")
    public WebElement CountryDropDown;
    @FindBy(how = How.CLASS_NAME, using = "select2-input")
    public WebElement CountryDropDownInput;
    @FindBy(how = How.CLASS_NAME, using = "select2-result-label")
    public WebElement CountryDropDownOption;
    //

    @FindBy(how = How.NAME, using = "billing_address_1")
    public WebElement Address1;

    @FindBy(how = How.NAME, using = "billing_address_2")
    public WebElement Address2;

    @FindBy(how = How.NAME, using = "billing_city")
    public WebElement City;

    @FindBy(how = How.NAME, using = "billing_state")
    public WebElement County;

    @FindBy(how = How.NAME, using = "billing_postcode")
    public WebElement Zip;

    @FindBy(how = How.NAME, using = "save_address")
    public WebElement SaveButton;


    public void ChangeBillingAddress(String FName, String LName, String CName, String Email, String Ph, String Countr,
                                     String A1, String A2, String C, String Count, String Postc)
    {
        FirstName.clear();
        LastName.clear();
        CompanyName.clear();
        Mail.clear();
        Phone.clear();
        Address1.clear();
        Address2.clear();
        City.clear();
        County.clear();
        Zip.clear();

        FirstName.sendKeys(FName);
        LastName.sendKeys(LName);
        CompanyName.sendKeys(CName);
        Mail.sendKeys(Email);
        Phone.sendKeys(Ph);

        //Working with shity dropdownlist
        CountryDropDown.click();
        CountryDropDownInput.sendKeys(Countr);
        CountryDropDownOption.click();
        //

        Address1.sendKeys(A1);
        Address2.sendKeys(A2);
        City.sendKeys(C);
        County.sendKeys(Count);
        Zip.sendKeys(Postc);

        SaveButton.click();
    }

    public MyAccountAddressesPage(WebDriver driver) {
        super(driver);
    }
}
