package stepDefinitions;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.ContactPojo;

import static base_urls.ContactListAppBaseUrl.spec;
import static io.restassured.RestAssured.given;


public class GetRequestStepDefinitions {


    Response response;
    ContactPojo contactPojoExpectedData;

    @Given("send the get request and get the response")
    public void sendTheGetRequestAndGetTheResponse() {
        //Set the url
        spec.pathParams("first","contacts");


        //Send the request and get the response
        response = given(spec).get("{first}");
        response.prettyPrint();

    }

    @Then("validate response body")
    public void validateResponseBody() throws JsonProcessingException {

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(200,response.statusCode());
        Assert.assertTrue(jsonPath.getString("firstName").contains("Arda"));
        Assert.assertTrue(jsonPath.getString("lastName").contains("Guler"));


    }
}
