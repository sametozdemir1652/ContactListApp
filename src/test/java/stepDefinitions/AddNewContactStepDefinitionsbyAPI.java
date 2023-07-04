package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.ContactPojo;

import static base_urls.ContactListAppBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class AddNewContactStepDefinitionsbyAPI {


    ContactPojo expectedDataPojo;
    Response response;
    Faker faker = new Faker();


    @Given("send the post request for creating new contact")
    public void sendThePostRequestForCreatingNewContact() {

        //Set the url
        spec.pathParams("first","contacts");

        //Set the expected data
        String firstNameApi = faker.name().firstName();
        String lastNameApi = faker.name().lastName();

        expectedDataPojo = new ContactPojo(firstNameApi,lastNameApi);

        //Send the request and get the response
        response = given(spec).body(expectedDataPojo).post("{first}");
        response.prettyPrint();


    }

    @Then("get the response and validate")
    public void getTheResponseAndValidate() {

        JsonPath jsonPath = response.jsonPath();
        //Do assertion
        Assert.assertEquals(201,response.statusCode());
        Assert.assertEquals(expectedDataPojo.getFirstName(),jsonPath.getString("firstName"));
        Assert.assertEquals(expectedDataPojo.getLastName(),jsonPath.getString("lastName"));

    }
}






