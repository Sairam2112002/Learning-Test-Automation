package learning.restassured.tutorials.authentications;

import learning.utilities.FileReader;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import static learning.restassured.APIKeysPath.OPEN_WEATHER_MAP_API_KEY_PATH;

public class AuthenticationsTest {
    @Test(priority = 1)
    public void basicAuthentication() {
        given()
                .auth()
                .basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true));
    }

    @Test(priority = 2)
    public void digestAuthentication() {
        given()
                .auth()
                .digest("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true));
    }

    @Test(priority = 3)
    public void preemptiveAuthentication() {
        given()
                .auth()
                .preemptive()
                .basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true));
    }

    @Test(priority = 4)
    public void bearerTokenAuthentication() {
        String bearerToken = "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";
        given()
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200);
    }

    @Test(priority = 5)
    public void oAuth2Authentication() {
        String accessToken = "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";
        given()
                .auth()
                .oauth2(accessToken)
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200);
    }

    @Test(priority = 6)
    public void apiKeyAuthentication() throws IOException {
        String apiKey = FileReader.readPropertiesFile(OPEN_WEATHER_MAP_API_KEY_PATH).getProperty("openWeatherMapApiKey");
        given()
                .queryParam("appid", apiKey)
                .when()
                .get("http://api.openweathermap.org/data/2.5/weather?q=hyderabad")
                .then()
                .statusCode(200)
                .body("coord.lon", equalTo(78.4744F))
                .log().body();
    }
}
