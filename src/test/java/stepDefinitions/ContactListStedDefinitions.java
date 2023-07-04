package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ContactListPage;
import pages.RegistrationPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

import static utilities.ReusableMethods.alertAccept;
import static utilities.ReusableMethods.alertWait;

public class ContactListStedDefinitions {

    Faker faker = new Faker();
    static String contactFirstName;
    static String contactLastName;

    ContactListPage contactListPage = new ContactListPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @When("validate contact list is viewed")
    public void validateContactListIsViewed() {
        ReusableMethods.wait(1);
        Assert.assertTrue(contactListPage.contactListHeader.isDisplayed());
    }

    @And("click Add a New Contact button")
    public void clickAddANewContactButton() {
        ReusableMethods.wait(2);
        contactListPage.addANewContactButton.click();
    }

    @And("enter firstname, lastname and other user informations")
    public void enterFirstnameLastnameAndOtherUserInformations() {
        contactFirstName = faker.name().firstName();
        contactLastName = faker.name().lastName();
        ReusableMethods.wait(1);
        registrationPage.firstName.sendKeys(contactFirstName);
        ReusableMethods.wait(1);
        registrationPage.lastName.sendKeys(contactLastName);
        ReusableMethods.wait(2);

    }

    @And("click on the person to be updated or deleted")
    public void clickOnThePersonToBeUpdated() {
        ReusableMethods.wait(1);
        List<WebElement> contactList = contactListPage.contactList;
        for (int i = 0; i < contactList.size(); i++) {

            if (contactList.get(i).getText().contains(contactFirstName) && contactList.get(i).getText().contains(contactLastName)) {
                Driver.getDriver().findElement(By.xpath("(//*[@id='myTable']/tr/td[2])[" + (i + 1) + "]")).click();
                break;
            }
        }
    }

    @And("click Edit Contact button")
    public void clickEditContactButton() {
        ReusableMethods.wait(1);
        contactListPage.editContactButton.click();
    }

    @And("update last name")
    public void updateLastName() {
        contactLastName = faker.name().lastName();
        ReusableMethods.wait(1);
        registrationPage.lastName.clear();
        ReusableMethods.wait(1);
        registrationPage.lastName.sendKeys(contactLastName);
    }

    @Then("validate contact details updated")
    public void validateContactDetailsUpdated() {
        ReusableMethods.wait(2);
        Assert.assertEquals(contactLastName, registrationPage.lastName.getText());
    }

    @And("click Delete Contact button")
    public void clickDeleteContactButton() {
        ReusableMethods.wait(1);
        contactListPage.deleteContactButton.click();

    }

    @And("accept alert")
    public void acceptAlert() {
        alertWait(5);
        alertAccept();
    }

    @And("validate contact is deleted")
    public void validateContactIsDeleted() {
        boolean flag = true;
        List<WebElement> contactList = contactListPage.contactList;
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(contactList.get(i).getText());
            if (contactList.get(i).getText().contains(contactFirstName + " " + contactLastName)) {
                flag = false;
            }
        }
        Assert.assertTrue(flag);

    }


}
