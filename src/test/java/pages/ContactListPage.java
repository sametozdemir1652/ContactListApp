package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ContactListPage {

    public ContactListPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h1[.='Contact List']")
    public WebElement contactListHeader;

    @FindBy(id = "add-contact")
    public WebElement addANewContactButton;

    @FindBy(xpath = "//*[@id='myTable']/tr/td[2]")
    public List<WebElement> contactList;

    @FindBy(id = "edit-contact")
    public WebElement editContactButton;

    @FindBy(id = "delete")
    public WebElement deleteContactButton;


}
