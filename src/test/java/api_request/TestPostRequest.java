package api_request;

import data.RandomData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.when;

public class TestPostRequest {
    Response response;

    @BeforeMethod
    public void createUser() {
        HashMap<String, String> requestBody = new HashMap<>();
        String name = RandomData.firstName();
        requestBody.put("name", name);
        requestBody.put("job", "qa");

        response = RestAssured.given().baseUri("https://reqres.in").contentType(ContentType.JSON).body(requestBody).
                when().post("/api/users").
                then().extract().response();
    }

    @Test
    public void testStatusCode() {
        System.out.println(response.getStatusCode());
        System.out.println(response.body().asString());
    }
}
