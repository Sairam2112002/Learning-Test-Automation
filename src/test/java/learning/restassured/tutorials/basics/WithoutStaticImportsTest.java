package learning.restassured.tutorials.basics;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class WithoutStaticImportsTest {
    private final SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    private void setBaseUri() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
    }

    @Test(priority = 1)
    public void getRequest() {
        RequestSpecification getRequest = RestAssured.given();
        Response getResponse = getRequest.request(Method.GET, "/1");
        getResponse.prettyPrint();
        JsonPath jsonPath = getResponse.jsonPath();
        softAssert.assertEquals(jsonPath.getInt("id"), 1);
        softAssert.assertEquals(getResponse.getStatusCode(), 200);
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void postRequest() {
        RequestSpecification postRequest = RestAssured.given();
        HashMap body = new HashMap<>();
        body.put("userId", 1);
        body.put("id", 101);
        body.put("title", "This is a sample title");
        body.put("body", "This is a sample body");
        Response postResponse = postRequest
                .header("Content-Type", "application/json")
                .body(body)
                .request(Method.POST);
        JsonPath jsonPath = postResponse.jsonPath();
        softAssert.assertEquals(jsonPath.getInt("id"), 101);
        softAssert.assertEquals(postResponse.getStatusCode(), 201);
        softAssert.assertAll();
    }
}
