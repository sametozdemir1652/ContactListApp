package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken(){

        String body = "{\"email\": \"kyriaki.sofiya@fixedfor.com\",\n\"password\": \"Ab123456\"\n}";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");

        return response.jsonPath().getString("token");
    }

}



