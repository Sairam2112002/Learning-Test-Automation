package learning.apitesting.restassured.authentications;

import learning.apitesting.restassured.RestAssuredBaseTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class AuthenticationsTest extends RestAssuredBaseTest {
    @BeforeGroups(groups = {"postmanAuthentications"})
    public void setPostmanUri() {
        baseURI = "https://postman-echo.com/";
    }

    @BeforeGroups(groups = {"githubAuthentications"})
    public void setGithubUri() {
        baseURI = "https://api.github.com/";
    }

    @BeforeGroups(groups = {"openWeatherMapAuthentications"})
    public void setOpenWeatherMapUri() {
        baseURI = "http://api.openweathermap.org/";
    }

    @Test(priority = 1, groups = {"postmanAuthentications"})
    public void basicAuthentication() {
        given()
                .auth()
                .basic("postman", "password")
                .when()
                .get("basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().body();
    }

    @Test(priority = 2, groups = {"postmanAuthentications"})
    public void digestAuthentication() {
        given()
                .auth()
                .digest("postman", "password")
                .when()
                .get("basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().body();
    }

    @Test(priority = 3, groups = {"postmanAuthentications"})
    public void preemptiveAuthentication() {
        given()
                .auth()
                .preemptive()
                .basic("postman", "password")
                .when()
                .get("basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().body();
    }

    @Test(priority = 4, groups = {"githubAuthentications"})
    public void bearerTokenAuthentication() {
        given()
                .header("Authorization", "Bearer " + gitHubFineGrainToken)
                .when()
                .get("user/repos")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 5, groups = {"githubAuthentications"})
    public void oAuth2Authentication() {
        given()
                .auth()
                .oauth2(gitHubFineGrainToken)
                .when()
                .get("user/repos")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 6, groups = {"openWeatherMapAuthentications"})
    public void apiKeyAuthentication() {
        given()
                .queryParam("appid", openWeatherMapApiKey)
                .queryParam("q", "Hyderabad")
                .when()
                .get("data/2.5/weather?q=hyderabad")
                .then()
                .statusCode(200)
                .body("coord.lon", equalTo(78.4744F))
                .log().body();
    }
}
