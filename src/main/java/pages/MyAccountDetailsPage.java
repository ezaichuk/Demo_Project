package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountDetailsPage extends Page {

    @FindBy(how = How.NAME, using = "account_first_name")
    public WebElement accDetailsFirstName;

    @FindBy(how = How.NAME, using = "account_last_name")
    public WebElement accDetailsLastName;

    @FindBy(how = How.NAME, using = "account_email")
    public WebElement accDetailsEmail;

    @FindBy(how = How.NAME, using = "password_current")
    public WebElement accDetailsCurrPass;

    @FindBy(how = How.NAME, using = "password_1")
    public WebElement accDetailsNewPass;

    @FindBy(how = How.NAME, using = "password_2")
    public WebElement accDetailsConfirmNewPass;

    @FindBy(how = How.NAME, using = "save_account_details")
    public WebElement accDetailsSaveButton;


    public void SaveGeneralData(){
        String fn = accDetailsFirstName.getAttribute("value");
        String ln = accDetailsLastName.getAttribute("value");
        String mail = accDetailsEmail.getAttribute("value");

        accDetailsFirstName.clear();
        accDetailsLastName.clear();
        accDetailsEmail.clear();
        accDetailsFirstName.sendKeys(fn + "1");
        accDetailsLastName.sendKeys(ln + "1");
        accDetailsEmail.sendKeys(mail + "1");
        accDetailsSaveButton.click();
    }

    public void CleanAndRestore()
    {
        accDetailsFirstName.clear();
        accDetailsLastName.clear();
        accDetailsEmail.clear();
        accDetailsFirstName.sendKeys("Eugene");
        accDetailsLastName.sendKeys("Zaichuk");
        accDetailsEmail.sendKeys("ezaichuk@lohika.com");
        accDetailsSaveButton.click();
    }

    public void SavePassword()
    {
        accDetailsCurrPass.sendKeys("dferfrfzrhfcjnf");
        accDetailsNewPass.sendKeys("dferfrfzrhfcjnf1");
        accDetailsConfirmNewPass.sendKeys("dferfrfzrhfcjnf1");
        accDetailsSaveButton.click();
    }

    public void RestorePassword()
    {
        accDetailsCurrPass.sendKeys("dferfrfzrhfcjnf1");
        accDetailsNewPass.sendKeys("dferfrfzrhfcjnf");
        accDetailsConfirmNewPass.sendKeys("dferfrfzrhfcjnf");
        accDetailsSaveButton.click();
    }

    public MyAccountDetailsPage(WebDriver driver) {
        super(driver);
    }
}
