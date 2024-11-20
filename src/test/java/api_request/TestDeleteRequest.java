package api_request;


import data.RandomData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestDeleteRequest {
    Response response;

    @BeforeMethod
    public void deleteUser() {

        Map<String, String> deleteUserBody = new HashMap<>();
        String name = RandomData.firstName();
        deleteUserBody.put("name",name);
        deleteUserBody.put("job","ceo");
        response = RestAssured.given().baseUri("https://reqres.in").contentType(ContentType.JSON).body(deleteUserBody).
                when().delete("/api/users/2").
                then().extract().response();
    }

    @Test
    public void testStatusCode() {
        System.out.println(response.getStatusCode());
        System.out.println(response.body().asString());
    }
}
