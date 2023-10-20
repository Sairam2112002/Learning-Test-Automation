package learning.utilities.driverfactoryselenium.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import learning.utilities.driverfactoryselenium.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static learning.selenium.constants.SeleniumProperties.CHROME_ARGUMENT;

public class MyChromeDriver implements Driver {
    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(CHROME_ARGUMENT);
        return new ChromeDriver(chromeOptions);
    }
}
