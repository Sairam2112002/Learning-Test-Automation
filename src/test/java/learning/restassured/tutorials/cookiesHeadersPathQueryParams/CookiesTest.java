package learning.restassured.tutorials.cookiesHeadersPathQueryParams;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CookiesTest {
    @Test
    public void testCookies() {
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .cookie("AEC", "AUEFqZe6a7onCmhgJkAcxSr2-Ln-qDXgjC1m9w2r2pcRvGjpW53vE1GhaQ")
                .log().all();
    }

    @Test
    public void getCookieInfo() {
        Response response = given()
                .when()
                .get("https://www.google.com/");
        System.out.println(response.cookie("AEC"));
    }

    @Test
    public void getAllCookiesInfo() {
        Response response = given()
                .when()
                .get("https://www.google.com/");
        Map<String, String> cookies = response.getCookies();
        for(String key: cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }
    }
}
