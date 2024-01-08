package learning.cucumberselenium.general.utilities;

import learning.cucumberselenium.general.setup.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import static learning.cucumberselenium.general.setup.Constants.ENVIRONMENT_PROPERTIES_PATH;

public class PropertiesReader {
    public static void readProperties() {
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(ENVIRONMENT_PROPERTIES_PATH)) {
            properties.load(fileInputStream);
        } catch (IOException ioException) {
            System.out.println(Arrays.toString(ioException.getStackTrace()));
        }

        Constants.setBrowserName(properties.getProperty("browser"));
        Constants.setHeadless(properties.getProperty("headless").equals("true"));
        Constants.setCaptureScreenshots(properties.getProperty("captureScreenshots").equals("true"));
        Constants.setCaptureScreenshotsForFailedScenarios(properties.getProperty("captureScreenshotsForFailedScenarios").equals("true"));
    }
}
