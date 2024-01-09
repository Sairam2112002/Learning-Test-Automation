package learning.cucumberselenium.general.setup.drivers;

import learning.cucumberselenium.general.setup.Constants;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void setDriver(boolean isHeadless) {
        WebDriver driver =  switch(Constants.getBrowserName()) {
            case "chrome" -> new ChromeBrowserDriver().createDriver(isHeadless);
            case "edge" -> new EdgeBrowserDriver().createDriver(isHeadless);
            case "firefox" -> new FirefoxBrowserDriver().createDriver(isHeadless);
            default -> throw new IllegalArgumentException("Provided invalid Browser Type");
        };

        tlDriver.set(driver);
    }
}
