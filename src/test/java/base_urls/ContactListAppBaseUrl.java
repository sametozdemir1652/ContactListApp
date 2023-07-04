package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.Authentication.generateToken;

public class ContactListAppBaseUrl {

    public static RequestSpecification spec;

    public static void setUp(){

        spec= new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization",generateToken())
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com/")
                .build();

    }

}
