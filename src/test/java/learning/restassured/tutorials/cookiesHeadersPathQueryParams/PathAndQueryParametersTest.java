package learning.restassured.tutorials.cookiesHeadersPathQueryParams;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathAndQueryParametersTest {
    // https://reqres.in/api/users?page=2&id=5 -> Uri

    @Test
    public void pathAndQueryParameters() {
        given()
                .pathParam("myPath", "users")
                .queryParam("page", 2)
                .queryParam("id", 5)
                .when()
                .get("https://reqres.in/api/{myPath}")
                .then()
                .statusCode(200)
                .log().all();
    }
}
