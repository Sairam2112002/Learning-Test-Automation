package learning.apitesting.restassured.schemavalidation;

import learning.apitesting.restassured.RestAssuredBaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class XMLSchemaValidationTest extends RestAssuredBaseTest {
    @BeforeClass
    public void setup() {
        baseURI = "https://mocktarget.apigee.net/";
    }

    @Test
    public void xmlSchemaValidation() {
        given()
                .when()
                .get("xml")
                .then()
                .assertThat()
                .body(matchesXsdInClasspath("Schemas/GoogleMockXMLSchema.xsd"));
    }
}
