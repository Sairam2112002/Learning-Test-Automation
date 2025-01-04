package learning.apitesting.restassured.requestmetadata;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class QueryParametersTest {
    private static String apiKey;

    @BeforeClass
    public void setup() {
        baseURI = "https://api.nytimes.com/";

        String apiKeysJsonPath = System.getenv("API_KEYS_JSON_PATH");
        File file = new File(apiKeysJsonPath);
        JsonPath jsonPath = new JsonPath(file);
        apiKey = jsonPath.getString("newYorkTimesBooksAPIKey");
    }

    @Test(priority = 1)
    public void usingQueryParamMethod() {
        given()
                .queryParam("list", "hardcover-fiction")
                .queryParam("api-key", apiKey)
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
        queryParameters.put("api-key", apiKey);

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
                .queryParams("list", "hardcover-fiction", "api-key", apiKey)
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
                .get("svc/books/v3/lists.json?" + "list=hardcover-fiction" + "&" + "api-key=" + apiKey)
                .then()
                .statusCode(200)
                .log().body();
    }
}
