package learning.apitesting.restassured.generalrequests;

import io.restassured.response.Response;
import learning.apitesting.restassured.pojo.Person;
import learning.apitesting.restassured.pojo.User;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class DifferentWaysToPostTest {
    private static int createdUserID;
    private static Person person;

    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in/";
    }

    @AfterMethod
    public void deleteCreatedUser() {
        given()
                .when()
                .delete("/api/users/" + createdUserID)
                .then()
                .statusCode(204);
    }

    @Test(priority = 1)
    public void postUsingNormalStringBody() {
        String requestBody = """
                {
                    "name": "testName1",
                    "job": "testJobRole1"
                }
                """;
        Response response = given()
                .body(requestBody)
                .contentType("application/json")
                .post("/api/users");
        response.then().statusCode(201).log().body();
        createdUserID = response.jsonPath().getInt("id");
    }

    @Test(priority = 2)
    public void postUsingFormatSpecifiedString() {
        person = Person.getPerson();
        String requestBody = """
                {
                    "name": "%s",
                    "job": "%s"
                }
                """.formatted(person.firstName(), person.employmentRole());
        Response response = given()
                .body(requestBody)
                .contentType("application/json")
                .post("/api/users");
        response.then().statusCode(201).log().body();
        createdUserID = response.jsonPath().getInt("id");
    }

    @Test(priority = 3)
    public void postUsingHashMap() {
        person = Person.getPerson();
        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("name", person.firstName());
        requestBody.put("job", person.employmentRole());
        Response response = given()
                .body(requestBody)
                .contentType("application/json")
                .post("/api/users");
        response.then().statusCode(201).log().body();
        createdUserID = response.jsonPath().getInt("id");
    }

    @Test(priority = 4)
    public void postUsingJSONObject() {
        person = Person.getPerson();
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", person.firstName());
        requestBody.put("job", person.employmentRole());
        Response response = given()
                .body(requestBody.toString())
                .contentType("application/json")
                .post("/api/users");
        response.then().statusCode(201).log().body();
        createdUserID = response.jsonPath().getInt("id");
    }

    @Test(priority = 5)
    public void postUsingPojo() {
        person = Person.getPerson();
        User requestPojo = new User(person.firstName(), person.employmentRole());

        Response response = given()
                .body(requestPojo)
                .contentType("application/json")
                .post("/api/users");
        response.then().statusCode(201).log().body();
    }

    @Test(priority = 6)
    public void postUsingExternalJSONFile() throws FileNotFoundException {
        File file = new File("src\\test\\resources\\JSONBodies\\requestBody.json");
        FileReader fileReader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject requestBody = new JSONObject(jsonTokener);
        Response response = given()
                .body(requestBody.toString())
                .contentType("application/json")
                .post("/api/users");
        response.then().statusCode(201).log().body();
        createdUserID = response.jsonPath().getInt("id");
    }
}
