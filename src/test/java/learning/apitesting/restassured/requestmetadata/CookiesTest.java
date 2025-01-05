package learning.apitesting.restassured.requestmetadata;

import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import learning.apitesting.restassured.RestAssuredBaseTest;
import learning.apitesting.restassured.apichaining.CreateUserTest;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class CookiesTest extends RestAssuredBaseTest {
    @BeforeGroups(groups = {"setCookies"})
    public void setupSetCookies() {
        baseURI = "https://httpbin.org/";
        logger = LogManager.getLogger(CreateUserTest.class);
    }

    @BeforeGroups(groups = {"extractCookies", "validateCookies"})
    public void setupExtractCookies() {
        baseURI = "https://www.google.com/";
    }

    @Test(priority = 1, groups = {"setCookies"})
    public void usingCookieMethod() {
        given()
                .cookie(faker.harryPotter().book(), faker.harryPotter().spell())
                .when()
                .get("cookies/set")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 2, groups = {"setCookies"})
    public void usingHashmapWithCookiesMethod() {
        HashMap<String, Object> cookies = new HashMap<>();
        cookies.put(faker.harryPotter().book(), faker.harryPotter().spell());
        cookies.put(faker.harryPotter().book(), faker.harryPotter().spell());

        given()
                .cookies(cookies)
                .when()
                .get("cookies/set")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 3, groups = {"extractCookies"})
    public void extractingSingleCookieFromResponse() {
        Response response = given()
                .when()
                .get();
        logger.info(response.cookie("AEC"));
    }

    @Test(priority = 4, groups = {"extractCookies"})
    public void extractingSingleCookieUsingExtractMethod() {
        String aecCookie = given()
                .when()
                .get()
                .then()
                .extract()
                .cookie("AEC");
        logger.info(aecCookie);
    }

    @Test(priority = 5, groups = {"extractCookies"})
    public void extractingCookiesAsAMapUsingExtractMethod() {
        Map<String, String> cookies = given()
                .when()
                .get()
                .then()
                .extract()
                .cookies();
        for(String cookie: cookies.keySet()) {
            logger.info("{}: {}", cookie, cookies.get(cookie));
        }
    }

    @Test(priority = 6, groups = {"validateCookies"})
    public void validatingCookieValue() {
        SessionFilter sessionFilter = new SessionFilter();
        String nidCookie = given()
                .filter(sessionFilter)
                .when()
                .get()
                .then()
                .extract()
                .cookie("NID");

        given()
                .filter(sessionFilter)
                .when()
                .get()
                .then()
                .cookie("NID", nidCookie);
    }
}
