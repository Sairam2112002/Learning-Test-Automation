package learning.apitesting.restassured.parsing;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import learning.apitesting.restassured.RestAssuredBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParsingXMLResponseTest extends RestAssuredBaseTest {
    private static final SoftAssertions softAssertions = new SoftAssertions();
    private static final Logger LOGGER = LogManager.getLogger(ParsingXMLResponseTest.class);

    @BeforeClass
    public void setup() {
        baseURI = "https://mocktarget.apigee.net/";
    }

    @Test
    public void usingXMLPath() {
        Response response = given()
                .when()
                .get("xml");

        /*
         * response.xmlPath();
         * We can also use the above method to get the XmlPath object from the Response object
         */
        XmlPath xmlPath = new XmlPath(response.asPrettyString());

        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getHeader("Content-Type")).isEqualTo("application/xml; charset=utf-8");
        softAssertions.assertThat(xmlPath.getString("root.city")).isEqualTo("San Jose");
        softAssertions.assertThat(xmlPath.getString("root.firstName")).isEqualTo("John");
        softAssertions.assertThat(xmlPath.getString("root.lastName")).isEqualTo("Doe");
        softAssertions.assertThat(xmlPath.getString("root.state")).isEqualTo("CA");

        softAssertions.assertAll();
        LOGGER.info(response.asPrettyString());
    }
}
