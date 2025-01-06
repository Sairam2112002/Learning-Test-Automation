package learning.apitesting.restassured.serializationanddeserialization;

import com.google.gson.Gson;
import io.restassured.response.Response;
import learning.apitesting.restassured.RestAssuredBaseTest;
import learning.apitesting.restassured.pojo.JSONPlaceHolderPosts;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class DeserializationTest extends RestAssuredBaseTest {
    private static JSONPlaceHolderPosts post;

    @BeforeClass
    public void setup() {
        logger = LogManager.getLogger(DeserializationTest.class);
        baseURI = "https://jsonplaceholder.typicode.com/";
    }

    @Test(priority = 1)
    public void stringToPojoUsingGSON() {
        Response response = given()
                .pathParam("id", 1)
                .when()
                .get("posts/{id}");
        Gson gson = new Gson();
        post = gson.fromJson(response.asPrettyString(), JSONPlaceHolderPosts.class);

        logger.info(post);
    }

    @Test(priority = 2)
    public void jsonResponseToHashmapUsingAsMethod() {
        Response response = given()
                .pathParam("id", 1)
                .when()
                .get("posts/{id}");

        HashMap<Object, Object> map = response.as(HashMap.class);
        for(Object key: map.keySet()) {
            logger.info(key.toString() + ": " + map.get(key).toString().replaceAll("\n", ""));
        }
    }
}
