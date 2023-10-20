package learning.utilities.driverfactoryselenium;

import learning.utilities.driverfactoryselenium.drivers.MyChromeDriver;
import learning.utilities.driverfactoryselenium.drivers.MyEdgeDriver;
import learning.selenium.exceptions.DriverNotFoundException;
import learning.utilities.FileReader;

import java.io.IOException;

import static learning.selenium.constants.SeleniumProperties.DRIVER_PROPERTIES_PATH;

public class DriverFactory {
    public static Driver createDriver() throws DriverNotFoundException, IOException {
        return switch (FileReader.readPropertiesFile(DRIVER_PROPERTIES_PATH).getProperty("driver")) {
            case "chrome" -> new MyChromeDriver();
            case "edge" -> new MyEdgeDriver();
            default -> throw new DriverNotFoundException("Please provide a valid driver");
        };
    }
}
