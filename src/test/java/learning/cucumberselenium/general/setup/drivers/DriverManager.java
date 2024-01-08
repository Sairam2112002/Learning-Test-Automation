package learning.cucumberselenium.general.setup.drivers;

import learning.cucumberselenium.general.setup.Constants;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    public static WebDriver getDriver() {
        return switch(Constants.getBrowserName()) {
            case "chrome" -> new ChromeBrowserDriver().createDriver();
            case "edge" -> new EdgeBrowserDriver().createDriver();
            case "firefox" -> new FirefoxBrowserDriver().createDriver();
            default -> throw new IllegalArgumentException("Provided invalid Browser Type");
        };
    }
}
