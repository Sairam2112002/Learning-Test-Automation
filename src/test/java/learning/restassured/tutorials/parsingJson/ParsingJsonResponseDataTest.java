package learning.restassured.tutorials.parsingJson;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJsonResponseDataTest {
    @Test(priority = 1)
    public void usingJsonPathWithoutUsingResponse() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("page", equalTo(2))
                .body("total", equalTo(12))
                .body("data[0].id", equalTo(7));
    }

    @Test(priority = 2)
    public void usingResponseAndAssertionJSONObject() {
        Response response = given()
                .when()
                .get("https://reqres.in/api/users?page=2");
        JSONObject jsonObject = new JSONObject(response.asPrettyString());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
        softAssert.assertEquals(jsonObject.get("page"), 2);
        softAssert.assertEquals(jsonObject.get("total"), 12);
        softAssert.assertEquals(jsonObject.getJSONArray("data").getJSONObject(0).get("id"), 7);
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void usingResponseAndAssertionJSONPath() {
        Response response = given()
                .when()
                .get("https://reqres.in/api/users?page=2");
        JsonPath jsonPath = new JsonPath(response.asPrettyString());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
        softAssert.assertEquals(jsonPath.getInt("page"), 2);
        softAssert.assertEquals(jsonPath.getInt("total"), 12);
        softAssert.assertEquals(jsonPath.getInt("data[0].id"), 7);
        softAssert.assertEquals(jsonPath.getString("data[0].first_name"), "Michael");
        softAssert.assertAll();
    }
}
