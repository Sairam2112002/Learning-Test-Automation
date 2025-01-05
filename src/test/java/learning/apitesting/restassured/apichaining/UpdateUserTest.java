package learning.apitesting.restassured.apichaining;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import learning.apitesting.restassured.RestAssuredBaseTest;
import org.apache.logging.log4j.LogManager;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class UpdateUserTest extends RestAssuredBaseTest {
    @BeforeClass
    public void setup() {
        baseURI = "https://gorest.co.in/";
        logger = LogManager.getLogger(CreateUserTest.class);
    }

    @Test
    public void updateUser(ITestContext testContext) {
        Headers headers = new Headers(
                new Header("Accept", "application/json"),
                new Header("Content-Type", "application/json"),
                new Header("Authorization", "Bearer " + goRestApiToken));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", faker.name().fullName());
        jsonObject.put("gender", faker.demographic().sex());
        jsonObject.put("email", faker.internet().emailAddress());
        jsonObject.put("status", "active");

        String createdUserID = (String) testContext.getAttribute("userID");

        Response response = given()
                .headers(headers)
                .body(jsonObject.toString())
                .pathParam("userID", createdUserID)
                .when()
                .patch("public/v2/users/{userID}");

        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);

        logger.info(response.asPrettyString());
    }
}
