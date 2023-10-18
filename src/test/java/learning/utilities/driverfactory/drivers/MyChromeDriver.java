package learning.utilities.driverfactory.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import learning.utilities.driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static learning.constants.SeleniumProperties.CHROME_ARGUMENT;

public class MyChromeDriver implements Driver {
    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(CHROME_ARGUMENT);
        return new ChromeDriver(chromeOptions);
    }
}
