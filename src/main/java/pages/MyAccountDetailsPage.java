package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountDetailsPage extends Page {

    @FindBy(how = How.NAME, using = "account_first_name")
    public WebElement FirstName;

    @FindBy(how = How.NAME, using = "account_last_name")
    public WebElement LastName;

    @FindBy(how = How.NAME, using = "account_email")
    public WebElement Email;

    @FindBy(how = How.NAME, using = "password_current")
    public WebElement CurrPass;

    @FindBy(how = How.NAME, using = "password_1")
    public WebElement NewPass;

    @FindBy(how = How.NAME, using = "password_2")
    public WebElement ConfirmNewPass;

    @FindBy(how = How.NAME, using = "save_account_details")
    public WebElement SaveButton;


    public void SaveGeneralData(){
        String fn = FirstName.getAttribute("value");
        String ln = LastName.getAttribute("value");
        String mail = Email.getAttribute("value");

        FirstName.clear();
        LastName.clear();
        Email.clear();
        FirstName.sendKeys(fn + "1");
        LastName.sendKeys(ln + "1");
        Email.sendKeys(mail + "1");
        SaveButton.click();
    }

    public void CleanAndRestore()
    {
        FirstName.clear();
        LastName.clear();
        Email.clear();
        FirstName.sendKeys("Eugene");
        LastName.sendKeys("Zaichuk");
        Email.sendKeys("ezaichuk@lohika.com");
        SaveButton.click();
    }


    public void ChangeGeneralData(String FName, String LName, String Mail)
    {
        FirstName.clear();
        LastName.clear();
        Email.clear();
        FirstName.sendKeys(FName);
        LastName.sendKeys(LName);
        Email.sendKeys(Mail);
        SaveButton.click();
    }

    public void ChangePassword(String Currpass, String NPass, String ConfirmPass)
    {
        CurrPass.sendKeys(Currpass);
        NewPass.sendKeys(NPass);
        ConfirmNewPass.sendKeys(ConfirmPass);
        SaveButton.click();
    }

    public MyAccountDetailsPage(WebDriver driver) {
        super(driver);
    }
}
