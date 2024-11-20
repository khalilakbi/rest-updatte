package api_request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPutRequest {
   Response response;
    @BeforeMethod
    public void updateUser() {
        response = RestAssured.given().baseUri("https://reqres.in").
                when().put("/api/users/2").
                then().extract().response();
    }
    @Test
    public void testStatusCode(){
        System.out.println(response.getStatusCode());
    }
}
