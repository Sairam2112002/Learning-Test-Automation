package learning.cucumberselenium.general.setup.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowserDriver implements Drivers {
    @Override
    public WebDriver createDriver(boolean isHeadless) {
        WebDriverManager.firefoxdriver().setup();

        if(isHeadless) {
            return new FirefoxDriver(new FirefoxOptions().addArguments("--headless"));
        } else {
            return new FirefoxDriver();
        }
    }
}
