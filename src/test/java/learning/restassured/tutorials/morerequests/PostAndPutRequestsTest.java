package learning.restassured.tutorials.morerequests;

import learning.restassured.utilities.UserPojo;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

// Same as below for "PUT" requests, bout only the uri changes to a specified item
public class PostAndPutRequestsTest {
    @BeforeClass
    private void setBaseUri() {
        baseURI = "https://jsonplaceholder.typicode.com/posts";
    }

    @Test(priority = 1)
    public void postUsingHashMap() {
        HashMap body = new HashMap<>();
        body.put("userId", 1);
        body.put("id", 101);
        body.put("title", "This is a sample title");
        body.put("body", "This is a sample body");

        given()
                .contentType("application/json")
                .body(body)
                .when()
                .post()
                .then()
                .statusCode(201)
                .body("id", equalTo(101))
                .body("userId", equalTo(1))
                .body("title", equalTo("This is a sample title"))
                .body("body", equalTo("This is a sample body"))
                .log().body();
    }

    @Test(priority = 2)
    public void postUsingString() {
        String body = """
                {
                    "userId": 1,
                    "id": 101,
                    "title": "This is a sample title",
                    "body": "This is a sample body"
                }""";

        given()
                .contentType("application/json")
                .body(body)
                .when()
                .post()
                .then()
                .statusCode(201)
                .body("userId", equalTo(1))
                .body("id", equalTo(101))
                .body("title", equalTo("This is a sample title"))
                .body("body", equalTo("This is a sample body"))
                .log().body();
    }

    @Test(priority = 3)
    public void postUsingJsonObject() {
        JSONObject body = new JSONObject();
        body.put("userId", 1);
        body.put("id", 101);
        body.put("title", "This is a sample title");
        body.put("body", "This is a sample body");

        given()
                .contentType("application/json")
                .body(body.toString())
                .when()
                .post()
                .then()
                .statusCode(201)
                .body("userId", equalTo(1))
                .body("id", equalTo(101))
                .body("title", equalTo("This is a sample title"))
                .body("body", equalTo("This is a sample body"))
                .log().body();
    }

    @Test(priority = 4)
    public void postUsingPojo() {
        UserPojo body = new UserPojo();
        body.setUserId(1);
        body.setId(101);
        body.setTitle("This is a sample title");
        body.setBody("This is a sample body");

        given()
                .contentType("application/json")
                .body(body)
                .when()
                .post()
                .then()
                .statusCode(201)
                .body("userId", equalTo(1))
                .body("id", equalTo(101))
                .body("title", equalTo("This is a sample title"))
                .body("body", equalTo("This is a sample body"))
                .log().body();
    }

    @Test(priority = 5)
    public void postUsingExternalJsonFile() throws FileNotFoundException {
        File file = new File("C:\\Users\\CHAITRA\\OneDrive\\Learning - Code\\Learning-Test Automation\\src\\test\\resources\\body.json");
        FileReader fileReader = new FileReader(file);
        JSONTokener tokener = new JSONTokener(fileReader);
        JSONObject body = new JSONObject(tokener);

        given()
                .contentType("application/json")
                .body(body.toString())
                .when()
                .post()
                .then()
                .statusCode(201)
                .body("userId", equalTo(1))
                .body("id", equalTo(101))
                .body("title", equalTo("This is a sample title"))
                .body("body", equalTo("This is a sample body"))
                .log().body();
    }
}
