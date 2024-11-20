package api_request;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestGetRequest {
    Response response;

    @BeforeMethod
    public void getAllUsers() {
        response = RestAssured.given().baseUri("https://reqres.in").
                when().get("/api/users?page=2").
                then().extract().response();

    }

    @Test
    public void testStatusCode() {
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testStatusLine() {
        System.out.println(response.getStatusLine());
        Assert.assertTrue(response.statusLine().contains("200 OK"));
    }
    @Test
    public void testContentType(){
        System.out.println(response.header("Content-Type"));
        Assert.assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
    }
    @Test
    public void testResponseBody(){
        System.out.println(response.body().asString());
        JsonPath jsonPath = response.jsonPath();
        String email = jsonPath.get("data[0].email");
        System.out.println(email);
        Assert.assertEquals(email,"michael.lawson@reqres.in");
    }
}
