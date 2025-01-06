package learning.apitesting.restassured.schemavalidation;

import io.restassured.module.jsv.JsonSchemaValidator;
import learning.apitesting.restassured.RestAssuredBaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class JSONSchemaValidationTest extends RestAssuredBaseTest {
    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in/";
    }

    @Test
    public void jsonSchemaValidation() {
        given()
                .queryParam("page", 2)
                .when()
                .get("api/users")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/ReqresUsersJSONSchema.json"));
    }
}
