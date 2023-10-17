package learning.restassured.tutorials.basics;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// The following must be imported as static to use directly without using their Class Name
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class WithStaticImportsTest {
    @Test(priority = 1)
    public void getRequest() {
        baseURI = "https://jsonplaceholder.typicode.com/users";
        given()
                .get("/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", equalTo("Bret"))
                .body("address.street", equalTo("Kulas Light"))
                .log().body();
    }

    @Test(priority = 2)
    public void postRequest() {
        baseURI = "https://jsonplaceholder.typicode.com/posts";
        HashMap body = new HashMap<>();
        body.put("userId", 1);
        body.put("id", 101);
        body.put("title", "This is a sample title");
        body.put("body", "This is a sample body");

        given().
                contentType("application/json")
                .body(body)
                .when()
                .post()
                .then()
                .statusCode(201)
                .body("id", equalTo(101))
                .body("userId", equalTo(1))
                .log().all();
    }
}