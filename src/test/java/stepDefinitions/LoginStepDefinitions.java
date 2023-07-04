package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class LoginStepDefinitions {

    RegistrationPage registrationPage = new RegistrationPage();

    @When("enter email address")
    public void enterEmailAddress() {
        registrationPage.email.sendKeys(RegistrationStepDefinitions.email);
    }

    @And("enter password")
    public void enterPassword() {
        registrationPage.password.sendKeys(RegistrationStepDefinitions.password);
    }

    @When("enter your email address")
    public void enterYourEmailAddress() {
        ReusableMethods.wait(1);
        registrationPage.email.sendKeys(ConfigReader.getProperty("email"));
    }

    @And("enter your password")
    public void enterYourPassword() {
        ReusableMethods.wait(1);
        registrationPage.password.sendKeys(ConfigReader.getProperty("password"));
    }
}
