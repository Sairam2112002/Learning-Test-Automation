package learning.cucumberselenium.general.setup.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowserDriver implements Drivers {
    @Override
    public WebDriver createDriver(boolean isHeadless) {
        WebDriverManager.edgedriver().setup();

        if(isHeadless) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setCapability("use_chromium", true);
            edgeOptions.setCapability("headless", true);

            return new EdgeDriver(edgeOptions);
        } else {
            return new EdgeDriver();
        }
    }
}
