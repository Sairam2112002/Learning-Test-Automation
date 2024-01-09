package learning.cucumberselenium.general.utilities;

import learning.cucumberselenium.general.setup.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import static learning.cucumberselenium.general.setup.Constants.ENVIRONMENT_PROPERTIES_PATH;

public class PropertiesReader {
    private static final Logger LOGGER = LogManager.getLogger(PropertiesReader.class);

    public static void readProperties() {
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(ENVIRONMENT_PROPERTIES_PATH)) {
            properties.load(fileInputStream);
        } catch (IOException ioException) {
            LOGGER.error(Arrays.toString(ioException.getStackTrace()));
        }

        Constants.setBrowserName(properties.getProperty("browser"));
        Constants.setHeadless(properties.getProperty("headless").equals("true"));
        Constants.setCaptureScreenshots(properties.getProperty("captureScreenshots").equals("true"));
        Constants.setCaptureScreenshotsForFailedScenarios(properties.getProperty("captureScreenshotsForFailedScenarios").equals("true"));
    }
}
