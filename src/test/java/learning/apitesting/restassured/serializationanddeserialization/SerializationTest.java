package learning.apitesting.restassured.serializationanddeserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import learning.apitesting.restassured.RestAssuredBaseTest;
import learning.apitesting.restassured.pojo.Person;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SerializationTest extends RestAssuredBaseTest {
    private static Person person;

    @BeforeClass
    public void setup() {
        person = Person.getPerson();
        logger = LogManager.getLogger(SerializationTest.class);
    }

    @Test(priority = 1)
    public void serializationUsingGSONToGetNormalString() {
        Gson gson = new Gson();
        String json = gson.toJson(person);
        logger.info(json);
    }

    @Test(priority = 2)
    public void serializationUsingGSONToGetPrettyString() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        String json = gson.toJson(person);
        logger.info(json);
    }
}
