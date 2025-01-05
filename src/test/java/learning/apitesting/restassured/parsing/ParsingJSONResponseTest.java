package learning.apitesting.restassured.parsing;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ParsingJSONResponseTest {
    private static String apiKey;
    private static SoftAssertions softAssertions;
    private static final Logger LOGGER = LogManager.getLogger(ParsingJSONResponseTest.class);

    @BeforeClass
    public void setup() {
        baseURI = "https://api.nytimes.com/";

        String apiKeysJsonPath = System.getenv("API_KEYS_JSON_PATH");
        File file = new File(apiKeysJsonPath);
        JsonPath jsonPath = new JsonPath(file);
        apiKey = jsonPath.getString("newYorkTimesBooksAPIKey");
    }

    @Test(priority = 1)
    public void usingThenMethods() {
        given()
                .queryParam("api-key", apiKey)
                .queryParam("list", "hardcover-fiction")
                .when()
                .get("svc/books/v3/lists.json")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("Content-Encoding", "gzip")
                .body("status", equalTo("OK"))
                .body("copyright", equalTo("Copyright (c) 2025 The New York Times Company.  All Rights Reserved."))
                .body("results[0].book_details[0].title", equalTo("JAMES"))
                .body("results[0].book_details[0].author", equalTo("Percival Everett"))
                .log().body();
    }

    @Test(priority = 2)
    public void usingResponseAndJSONObject() {
        Response response = given()
                .queryParam("api-key", apiKey)
                .queryParam("list", "hardcover-fiction")
                .when()
                .get("svc/books/v3/lists.json");

        JSONObject jsonObject = new JSONObject(response.asPrettyString());
        softAssertions = new SoftAssertions();

        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getHeader("Content-Type")).isEqualTo("application/json; charset=UTF-8");
        softAssertions.assertThat(response.getHeader("Content-Encoding")).isEqualTo("gzip");
        softAssertions.assertThat(jsonObject.getString("status")).isEqualTo("OK");
        softAssertions.assertThat(jsonObject.getString("copyright")).isEqualTo("Copyright (c) 2025 The New York Times Company.  All Rights Reserved.");
        softAssertions.assertThat(jsonObject
                .getJSONArray("results")
                .getJSONObject(0).getJSONArray("book_details").getJSONObject(0).getString("title")).isEqualTo("JAMES");
        softAssertions.assertThat(jsonObject
                .getJSONArray("results")
                .getJSONObject(0).getJSONArray("book_details").getJSONObject(0).getString("author")).isEqualTo("Percival Everett");

        softAssertions.assertAll();
        LOGGER.info(response.asPrettyString());
    }

    @Test(priority = 3)
    public void usingResponseAndJSONPath() {
        Response response = given()
                .queryParam("api-key", apiKey)
                .queryParam("list", "hardcover-fiction")
                .when()
                .get("svc/books/v3/lists.json");

        /*
         * response.jsonPath();
         * We can also use the above method to get the JsonPath object from the Response object
         */
        JsonPath jsonPath = new JsonPath(response.asPrettyString());
        softAssertions = new SoftAssertions();

        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getHeader("Content-Type")).isEqualTo("application/json; charset=UTF-8");
        softAssertions.assertThat(response.getHeader("Content-Encoding")).isEqualTo("gzip");
        softAssertions.assertThat(jsonPath.getString("status")).isEqualTo("OK");
        softAssertions.assertThat(jsonPath.getString("copyright")).isEqualTo("Copyright (c) 2025 The New York Times Company.  All Rights Reserved.");
        softAssertions.assertThat(jsonPath.getString("results[0].book_details[0].title")).isEqualTo("JAMES");
        softAssertions.assertThat(jsonPath.getString("results[0].book_details[0].author")).isEqualTo("Percival Everett");

        softAssertions.assertAll();
        LOGGER.info(response.asPrettyString());
    }
}
