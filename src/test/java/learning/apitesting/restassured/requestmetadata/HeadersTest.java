package learning.apitesting.restassured.requestmetadata;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import learning.apitesting.restassured.RestAssuredBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class HeadersTest extends RestAssuredBaseTest {
    private static final Logger LOGGER = LogManager.getLogger(HeadersTest.class);

    @BeforeClass
    public void setup() {
        baseURI = "https://www.google.com/";
    }

    @Test(priority = 1, groups = {"settingHeaders"})
    public void usingHeaderMethod() {
        given()
                .header("Content-Type", "application/json")
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    @Test(priority = 2, groups = {"settingHeaders"})
    public void usingHashmapWithHeadersMethod() {
        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", "application/json");

        given()
                .headers(headersMap)
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    @Test(priority = 3, groups = {"settingHeaders"})
    public void usingHeadersObjectWithHeadersMethod() {
        Headers headers = new Headers(
                new Header("Content-Type", "application/json"),
                new Header("Accept", "application/json")
        );

        given()
                .headers(headers)
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    @Test(priority = 4, groups = {"extractingHeaders"})
    public void extractingSingleHeaderUsingExtractMethod() {
        String contentTypeHeader = given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .header("Content-Type");
        LOGGER.info("Content-Type: {}", contentTypeHeader);
    }

    @Test(priority = 5, groups = {"extractingHeaders"})
    public void extractingToHeadersObjectUsingExtractMethod() {
        Headers headers = given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .headers();

        for(Header header: headers) {
            LOGGER.info("{}: {}", header.getName(), header.getValue());
        }
    }

    @Test(priority = 6, groups = {"validatingHeaders"})
    public void validatingHeaders() {
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .header("Content-Encoding", "gzip");
    }
}
