package learning.apitesting.restassured.requestmetadata;

import com.github.javafaker.Faker;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class CookiesTest {
    private static final Faker faker = new Faker();
    private static final Logger LOGGER = LogManager.getLogger(CookiesTest.class);

    @BeforeGroups(groups = {"setCookies"})
    public void setupSetCookies() {
        baseURI = "https://httpbin.org/";
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
        LOGGER.info(response.cookie("AEC"));
    }

    @Test(priority = 4, groups = {"extractCookies"})
    public void extractingSingleCookieUsingExtractMethod() {
        String aecCookie = given()
                .when()
                .get()
                .then()
                .extract()
                .cookie("AEC");
        LOGGER.info(aecCookie);
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
            LOGGER.info("{}: {}", cookie, cookies.get(cookie));
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
