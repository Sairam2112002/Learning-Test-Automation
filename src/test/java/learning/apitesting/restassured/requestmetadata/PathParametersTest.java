package learning.apitesting.restassured.requestmetadata;

import learning.apitesting.restassured.RestAssuredBaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class PathParametersTest extends RestAssuredBaseTest {
    @BeforeClass
    public void setup() {
        baseURI = "https://api.nytimes.com/";
    }

    @Test(priority = 1)
    public void usingPathParamMethod() {
        given()
                .pathParam("path1", "svc")
                .pathParam("path2", "books")
                .pathParam("path3", "v3")
                .when()
                .get("{path1}/{path2}/{path3}/lists.json?" + "list=hardcover-fiction" + "&" + "api-key=" + newYorkTimesApiKey)
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
                .get("{path1}/{path2}/{path3}/lists.json?" + "list=hardcover-fiction" + "&" + "api-key=" + newYorkTimesApiKey)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 3)
    public void usingMultipleArgumentsInPathParamsMethod() {
        given()
                .pathParams("path1", "svc", "path2", "books", "path3", "v3")
                .when()
                .get("{path1}/{path2}/{path3}/lists.json?" + "list=hardcover-fiction" + "&" + "api-key=" + newYorkTimesApiKey)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 4)
    public void usingInlinePathParameters() {
        given()
                .when()
                .get("svc/books/v3/lists.json?" + "list=hardcover-fiction" + "&" + "api-key=" + newYorkTimesApiKey)
                .then()
                .statusCode(200)
                .log().body();
    }
}
