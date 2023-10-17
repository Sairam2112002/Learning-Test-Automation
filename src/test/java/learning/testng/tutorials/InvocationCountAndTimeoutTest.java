package learning.testng.tutorials;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

// invocationCount
// invocationTimeout
// threadPoolSize

/*
invocationTimeOut = maximum amount of time(millis) allowed for all the invocations combined.
*/
public class InvocationCountAndTimeoutTest {
    @Test(invocationCount = 10, invocationTimeOut = 50000)
    public void test1() throws InterruptedException {
        baseURI = "https://jsonplaceholder.typicode.com/users";
        given()
                .get("/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", equalTo("Bret"))
                .body("address.street", equalTo("Kulas Light"))
                .log().body();
    }

/*
timeOut = maximum amount if time allowed for each test (if there is invocationCount, then for each invocation)
 */

    @Test(invocationCount = 10, timeOut = 2000)
    public void test2() throws InterruptedException {
        baseURI = "https://jsonplaceholder.typicode.com/users";
        given()
                .get("/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", equalTo("Bret"))
                .body("address.street", equalTo("Kulas Light"))
                .log().body();
    }
}
