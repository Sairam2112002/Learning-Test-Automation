package learning.apitesting.restassured.generalrequests;

import io.restassured.response.Response;
import learning.apitesting.restassured.pojo.Person;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

public class GeneralRequestsTest {
    private static Person person;
    private static int createdUserID;

    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in/";
    }

    @Test(priority = 1)
    public void getUsersList() {
        given()
                .when()
                .get("api/users?page=2")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 2)
    public void createUser() {
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
                .post("api/users");
        response.then().statusCode(201).log().body();
        createdUserID = response.jsonPath().getInt("id");
    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    public void updateUser() {
        String requestBody = """
                {
                    "name": "%s",
                    "job": "%s"
                }
                """.formatted(person.firstName(), person.employmentRole());
        given()
                .body(requestBody)
                .contentType("application/json")
                .when()
                .put("api/users/" + createdUserID)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 4, dependsOnMethods = {"createUser", "updateUser"})
    public void deleteUser() {
        given()
                .when()
                .delete("api/users/" + createdUserID)
                .then()
                .statusCode(204);
    }
}
