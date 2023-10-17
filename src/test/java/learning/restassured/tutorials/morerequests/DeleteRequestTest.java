package learning.restassured.tutorials.morerequests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteRequestTest {
    @BeforeClass
    private void setBaseUri() {
        baseURI = "https://jsonplaceholder.typicode.com/";
    }

    @Test(priority = 1)
    public void deleteRequest() {
        given()
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200)
                .body("data[0]", equalTo(null))
                .log().body();
    }
}
