package learning.apitesting.restassured.requestmetadata;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class PathParametersTest {
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
    public void usingPathParamMethod() {
        given()
                .pathParam("path1", "svc")
                .pathParam("path2", "books")
                .pathParam("path3", "v3")
                .when()
                .get("{path1}/{path2}/{path3}/lists.json?" + "list=hardcover-fiction" + "&" + "api-key=" + apiKey)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 2)
    public void usingHashmapWithPathParamsMethod() {
        HashMap<String, Object> pathParameters = new HashMap<>();
        pathParameters.put("path1", "svc");
        pathParameters.put("path2", "books");
        pathParameters.put("path3", "v3");

        given()
                .pathParams(pathParameters)
                .when()
                .get("{path1}/{path2}/{path3}/lists.json?" + "list=hardcover-fiction" + "&" + "api-key=" + apiKey)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 3)
    public void usingMultipleArgumentsInPathParamsMethod() {
        given()
                .pathParams("path1", "svc", "path2", "books", "path3", "v3")
                .when()
                .get("{path1}/{path2}/{path3}/lists.json?" + "list=hardcover-fiction" + "&" + "api-key=" + apiKey)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 4)
    public void usingInlinePathParameters() {
        given()
                .when()
                .get("svc/books/v3/lists.json?" + "list=hardcover-fiction" + "&" + "api-key=" + apiKey)
                .then()
                .statusCode(200)
                .log().body();
    }
}
