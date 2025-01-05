package learning.apitesting.restassured;

import com.github.javafaker.Faker;
import learning.utilities.constants.APIKeys;
import learning.utilities.readers.MyFileReaders;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;

public class RestAssuredBaseTest {
    public static Faker faker;
    public static Logger logger;
    public static SoftAssertions softAssertions;

    public static String gitHubFineGrainToken;
    public static String newYorkTimesApiKey;
    public static String goRestApiToken;
    public static String openWeatherMapApiKey;

    @BeforeTest
    public void baseSetup() {
        faker = new Faker();
        softAssertions = new SoftAssertions();

        MyFileReaders.readApiKeysJSONFile();
        HashMap<String, String> apiKeys = APIKeys.API_KEYS;
        gitHubFineGrainToken = apiKeys.get("GITHUB_FINE_GRAIN_TOKEN");
        newYorkTimesApiKey = apiKeys.get("NEW_YORK_TIMES_API_KEY");
        goRestApiToken = apiKeys.get("GO_REST_API_TOKEN");
        openWeatherMapApiKey = apiKeys.get("OPEN_WEATHER_MAP_API_KEY");
    }

    @AfterTest
    public void baseTearDown() {
        softAssertions.assertAll();
    }
}
