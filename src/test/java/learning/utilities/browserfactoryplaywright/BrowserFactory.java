package learning.utilities.browserfactoryplaywright;

import learning.playwright.exceptions.BrowserNotFoundException;
import learning.utilities.FileReader;
import learning.utilities.browserfactoryplaywright.browsers.MyChromiumBrowser;
import learning.utilities.browserfactoryplaywright.browsers.MyFirefoxBrowser;
import learning.utilities.browserfactoryplaywright.browsers.MyWebkitBrowser;

import java.io.IOException;

import static learning.playwright.constants.FilePaths.BROWSER_PROPERTIES_PATH;

public class BrowserFactory {
    public static Browsers createBrowser() throws IOException, BrowserNotFoundException {
        return switch (FileReader.readPropertiesFile(BROWSER_PROPERTIES_PATH).getProperty("browser")) {
            case "chromium" -> new MyChromiumBrowser();
            case "firefox" -> new MyFirefoxBrowser();
            case "webkit" -> new MyWebkitBrowser();
            default -> throw new BrowserNotFoundException("please provide a valid browser");
        };
    }
}
