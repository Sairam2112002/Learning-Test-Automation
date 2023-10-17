package learning.restassured.tutorials.cookiesHeadersPathQueryParams;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeadersTest {
    @Test
    public void testHeader() {
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .and() // and is optional, but we can use if we are doing multiple validations, but not necessary
                .header("Content-Encoding", "gzip");
    }

    @Test
    public void getHeaderInfo() {
        Response response = given()
                .when()
                .get("https://www.google.com/");
        System.out.println(response.getHeader("Content-Type"));
    }

    @Test
    public void getAllHeadersInfo() {
        Response response = given()
                .when()
                .get("https://www.google.com/");
        Headers headers = response.getHeaders();
        for(Header header: headers) {
            System.out.println(header.getName() + ": " + header.getValue());
        }
    }
}
