package learning.utilities.driverfactory;

import learning.utilities.driverfactory.drivers.MyChromeDriver;
import learning.utilities.driverfactory.drivers.MyEdgeDriver;
import learning.selenium.exceptions.BrowserNotFoundException;
import learning.utilities.FileReader;

import java.io.IOException;

import static learning.constants.SeleniumProperties.BROWSER_PROPERTIES_PATH;

public class DriverFactory {
    public static Driver createDriver() throws BrowserNotFoundException, IOException {
        return switch (FileReader.readPropertiesFile(BROWSER_PROPERTIES_PATH).getProperty("browser")) {
            case "chrome" -> new MyChromeDriver();
            case "edge" -> new MyEdgeDriver();
            default -> throw new BrowserNotFoundException("Please provide a valid browser");
        };
    }
}
