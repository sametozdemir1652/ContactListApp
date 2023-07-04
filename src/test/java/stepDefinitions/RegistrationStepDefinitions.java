package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class RegistrationStepDefinitions {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    static String firstName;
    static String lastName;
    static String email;
    static String password;


    @Given("go to home page")
    public void userGoesToHomePage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("click Sign up button")
    public void userClicksSignUpButton() {
        registrationPage.signUp.click();
    }

    @And("provide a valid firstname")
    public void userProvidesAValidFirstname() {
        firstName = faker.name().firstName();
        registrationPage.firstName.sendKeys(firstName);
    }

    @And("provide a valid lastname")
    public void userProvidesAValidLastname() {
        lastName = faker.name().lastName();
        registrationPage.lastName.sendKeys(lastName);
    }

    @And("provide a valid email address")
    public void userProvidesAValidEmailAddress() {
        email = faker.internet().emailAddress();
        registrationPage.email.sendKeys(email);
    }

    @And("provide a valid password at least seven characters long")
    public void userProvidesAValidPasswordAtLeastCharactersLong() {
        password = faker.internet().password(7,10);
        registrationPage.password.sendKeys(password);
    }

    @And("click Submit button")
    public void userClicksSubmitButton() {
        ReusableMethods.wait(2);
        registrationPage.submit.click();
    }

    @And("Close driver")
    public void closeDriver() throws InterruptedException {
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }

    @Then("validate account created")
    public void validateAccountCreated() {
        Assert.assertTrue(registrationPage.contactListHeader.isDisplayed());
    }
}
