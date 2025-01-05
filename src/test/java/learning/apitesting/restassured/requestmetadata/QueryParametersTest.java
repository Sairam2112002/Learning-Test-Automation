package learning.apitesting.restassured.requestmetadata;

import learning.apitesting.restassured.RestAssuredBaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class QueryParametersTest extends RestAssuredBaseTest {
    @BeforeClass
    public void Setup() {
        baseURI = "https://api.nytimes.com/";
    }

    @Test(priority = 1)
    public void usingQueryParamMethod() {
        given()
                .queryParam("list", "hardcover-fiction")
                .queryParam("api-key", newYorkTimesApiKey)
                .when()
                .get("svc/books/v3/lists.json")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 2)
    public void usingHashmapWithQueryParamsMethod() {
        HashMap<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("list", "hardcover-fiction");
        queryParameters.put("api-key", newYorkTimesApiKey);

        given()
                .queryParams(queryParameters)
                .when()
                .get("svc/books/v3/lists.json")
                .then()
                .statusCode(200)
                .log().body();

    }

    @Test(priority = 3)
    public void usingMultipleArgumentsInQueryParamsMethod() {
        given()
                .queryParams("list", "hardcover-fiction", "api-key", newYorkTimesApiKey)
                .when()
                .get("svc/books/v3/lists.json")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 4)
    public void usingInlineQueryParameters() {
        given()
                .when()
                .get("svc/books/v3/lists.json?" + "list=hardcover-fiction" + "&" + "api-key=" + newYorkTimesApiKey)
                .then()
                .statusCode(200)
                .log().body();
    }
}
