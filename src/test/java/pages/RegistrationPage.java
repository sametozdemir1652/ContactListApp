package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {

    public RegistrationPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "signup")
    public WebElement signUp;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit")
    public WebElement submit;

    @FindBy(xpath = "//h1[.='Contact List']")
    public WebElement contactListHeader;


}
