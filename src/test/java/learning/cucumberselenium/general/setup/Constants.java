package learning.cucumberselenium.general.setup;

import lombok.Getter;
import lombok.Setter;

public class Constants {
    public static final String ENVIRONMENT_PROPERTIES_PATH = "src/test/resources/environment.properties";

    @Getter @Setter
    private static String browserName;
    @Getter @Setter
    private static boolean headless;
    @Getter @Setter
    private static boolean captureScreenshots;
    @Getter @Setter
    private static boolean captureScreenshotsForFailedScenarios;
}
