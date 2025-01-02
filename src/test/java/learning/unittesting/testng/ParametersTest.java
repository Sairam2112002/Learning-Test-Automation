package learning.unittesting.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {
    private static final Logger LOGGER = LogManager.getLogger(ParametersTest.class);

    @Parameters({"first-name"})
    @Test
    public void parameterTest1(String firstName) {
        LOGGER.info(firstName);
    }

    @Parameters({"last-name"})
    @Test
    public void parameterTest2(String lastName) {
        LOGGER.info(lastName);
    }

    @Parameters({"gender"})
    @Test
    public void parameterTest3(String gender) {
        LOGGER.info(gender);
    }

    @Parameters({"first-name", "last-name", "gender"})
    @Test
    public void parameterTest4(String firstName, String lastName, String gender) {
        LOGGER.info(firstName + " " + lastName + " is a " + gender);
    }

    // If no parameter named "age" is found in the testng.xml file, the test method will receive the default value specified inside the @Optional annotation: "20".
    // Same for the other parameters
    @Parameters({"age", "height"})
    @Test
    public void parameterTest5(@Optional("20 years") String age, @Optional("5.5 feet") String height) {
        LOGGER.info(age + " and " + height);
    }
}
